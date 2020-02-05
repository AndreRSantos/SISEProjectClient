package com.insure.client;

import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;
import com.insure.client.security.*;

import javax.xml.ws.BindingProvider;
import java.util.List;

public class Client {
    private String clientID;
    private final ClaimDataStore claim;

    public Client(String role, int clientID) throws ClientException {
        this.clientID = role + clientID;

        ClaimDataStoreService cService = new ClaimDataStoreService();
        this.claim = (ClaimDataStore) cService.getClaimDataStorePort();

        if(!role.equals("officer") && !role.equals("insured")){
           throw new ClientException();
        }

        ((BindingProvider) claim).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8090/docstorage");

    }

    public int createClaim(String claimDescription) throws Exception {
        //Encrypted Claim send with client signature
        return claim.createClaim(clientID, EncryptPub.encryptMsg(claimDescription), Signature.signMessage(clientID, claimDescription));
    }

    public String claimToString(int claimId) throws Exception {
        String  encryptedID = EncryptPriv.encryptMsg(this.clientID, String.valueOf(claimId));
        return claim.claimToString(clientID, encryptedID);
    }

    public int addDocument(String docContent, int claimId) throws Exception {
        return claim.addDocument(clientID, claimId, EncryptPriv.encryptMsg(clientID,docContent), Signature.signMessage(clientID, docContent));
    }

    public String viewDocument(int docId, int claimID) throws Exception {
        //Encrypt request with privateKey to guarantee origin request
        String  encryptedID = EncryptPriv.encryptMsg(this.clientID, String.valueOf(claimID));

        //get document and signature
        List<String> docAndSignature = claim.viewDocument(clientID, encryptedID, docId);

        //check if client was the last one to change the document
        boolean check = false;
        try{
            check = VerifySignature.checkSignature(this.clientID, docAndSignature.get(0), docAndSignature.get(1));
        } catch(Exception e){
            //if there was an error decrypting, the client was not the last changing the doc
        }

        String docContent = DecryptPriv.decryptMsg(this.clientID, docAndSignature.get(0));

        return "Document was last changed by you: " + check +
                "\n Document Content: " + docContent;
    }

    public String listDocuments(int claimID) throws Exception {
        //Encrypt request with privateKey to guarantee origin request
        String  encryptedID = EncryptPriv.encryptMsg(this.clientID, String.valueOf(claimID));

        return claim.listDocuments(clientID, encryptedID);
    }

    public void editDocument(int docID, String docContent, int claimID) throws Exception {
        //Send new signed document
        claim.editDocument(this.clientID, claimID, docID, EncryptPriv.encryptMsg(clientID,docContent), Signature.signMessage(clientID,docContent));
    }

    String getClientID(){
        return this.clientID;
    }

}
