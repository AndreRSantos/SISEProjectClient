package com.insure.client;

import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;

import javax.xml.ws.BindingProvider;

public class Insured {
    private int number;
    private final ClaimDataStore claim;

    public Insured(int number){
        this.number = number;

        ClaimDataStoreService cService = new ClaimDataStoreService();

        this.claim = (ClaimDataStore) cService.getClaimDataStorePort();

        ((BindingProvider) claim).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8090/docstorage");

    }

    public int createClaim(String claimDescription){
        //encrypt data

        //return claimID
        return claim.createClaim(claimDescription);
    }

    public void addDocument(String docContent, int claimId){
        // encrypt data

        //mehtod not yet created:
        //claim.addDocument(claimId, docContent)
    }

}
