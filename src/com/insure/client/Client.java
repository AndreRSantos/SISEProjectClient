package com.insure.client;

import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;
import com.insure.client.security.EncryptPriv;

import javax.crypto.NoSuchPaddingException;
import javax.xml.ws.BindingProvider;
import java.security.NoSuchAlgorithmException;

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
        //return claimID
        return claim.createClaim(clientID, EncryptPriv.encrypt(clientID, claimDescription));
    }

    public String claimToString(int claimId){
        return claim.claimToString(clientID, claimId);
    }

    public int addDocument(String docContent, int claimId){
        // encrypt data

        return claim.addDocument(clientID, claimId, docContent);
    }

    public String viewDocument(int docId, int claimID){
            return claim.viewDocument(clientID, claimID, docId);
    }

    public String listDocuments(int claimID ){
        return claim.listDocuments(clientID,claimID);
    }

    public void editDocument(int docID, String docContent, int claimID){
        claim.editDocument(clientID, claimID, docID, docContent);
    }

    public String getClientID(){
        return this.clientID;
    }

}
