package com.insure.client;

import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;

import javax.xml.ws.BindingProvider;

public class Insured {
    private String number;
    private final ClaimDataStore claim;

    public Insured(int number){
        this.number ="insured"+ number;

        ClaimDataStoreService cService = new ClaimDataStoreService();

        this.claim = (ClaimDataStore) cService.getClaimDataStorePort();

        ((BindingProvider) claim).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://146.193.7.121:8090/docstorage");

    }

    public int createClaim(String claimDescription){
        //encrypt data

        //return claimID
        return claim.createClaim(number, claimDescription);
    }

    public String claimToString(int claimId){
        return claim.claimToString(number, claimId);
    }

    public int addDocument(String docContent, int claimId){
        // encrypt data

        return claim.addDocument(number, claimId, docContent);
    }

    public String viewDocument(int docId, int claimID){
            return claim.viewDocument(number, claimID, docId);
    }

    public String listDocuments(int claimID ){
        return claim.listDocuments(number,claimID);
    }


}
