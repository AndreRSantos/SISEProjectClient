package com.insure.client;

import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;
import com.insure.client.security.EncryptPriv;
import com.insure.client.security.EncryptPub;
import com.insure.client.security.Signature;

import javax.xml.ws.BindingProvider;

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
                "http://146.193.7.121:8090/docstorage");

    }

    public int createClaim(String claimDescription) throws Exception {
        //Encrypted Claim send with client signature
        return claim.createClaim(clientID, EncryptPub.encryptMsg(claimDescription), Signature.signMessage(clientID, claimDescription));
    }

    public String claimToString(int claimId) throws Exception {
        //Encript request(claimId) with privateKey
        return claim.claimToString(clientID,EncryptPriv.encryptMsg(clientID,String.valueOf(claimId)));
    }

    public int addDocument(String docContent, int claimId) throws Exception {
        //S
        return claim.addDocument(clientID, claimId, EncryptPriv.encryptMsg(clientID,docContent));
    }

    public String viewDocument(int docId, int claimID) throws Exception {
        //Encript request(claimId) with privateKey
        return claim.viewDocument(clientID, EncryptPriv.encryptMsg(clientID,String.valueOf(claimID)), docId);
    }

    public String listDocuments(int claimID ) throws Exception {
        //Encript request(claimId) with privateKey
        return claim.listDocuments(clientID,EncryptPriv.encryptMsg(clientID,String.valueOf(claimID)));
    }

    public void editDocument(int docID, String docContent, int claimID) throws Exception {
        //Encript request(claimId) with privateKey
        //Sign docContent = PrivaKey(docContent) + Signature(DocContent)
        claim.editDocument(clientID, EncryptPriv.encryptMsg(clientID,String.valueOf(claimID)), docID, EncryptPriv.encryptMsg(clientID,docContent),Signature.signMessage(clientID,docContent));
    }

    public String getClientID(){
        return this.clientID;
    }

}
