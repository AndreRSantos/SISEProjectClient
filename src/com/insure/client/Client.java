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
        //information sent with signature
        return claim.createClaim(clientID, EncryptPub.encryptMsg(claimDescription), Signature.signMessage(clientID, claimDescription));
    }

    public String claimToString(int claimId){
        //Encript request(claimId) with privateKey
        //ToDo
        return claim.claimToString(clientID, claimId);
    }

    public int addDocument(String docContent, int claimId){
        //Signature
        //ToDo
        return claim.addDocument(clientID, claimId, docContent);
    }

    public String viewDocument(int docId, int claimID){
        //Encript request(claimId) with privateKey
        //ToDo
        return claim.viewDocument(clientID, claimID, docId);
    }

    public String listDocuments(int claimID ){
        //Encript request(claimId) with privateKey
        //ToDo
        return claim.listDocuments(clientID,claimID);
    }

    public void editDocument(int docID, String docContent, int claimID){
        //Encript request(claimId) with privateKey
        //Sign docContent = PrivaKey(docContent) + Signature(DocContent)
        //ToDo
        claim.editDocument(clientID, claimID, docID, docContent);
    }

    public String getClientID(){
        return this.clientID;
    }

}
