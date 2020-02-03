package com.insure.client;

import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;
import com.insure.client.gen.Exception_Exception;

import javax.xml.ws.BindingProvider;
import java.util.Set;

public class Officer {
    private String id;
    private final ClaimDataStore claim;

    public Officer(int id) {
        this.id = "officer" + id;

        ClaimDataStoreService cService = new ClaimDataStoreService();

        this.claim = (ClaimDataStore) cService.getClaimDataStorePort();

        ((BindingProvider) claim).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://146.193.7.121:8090/docstorage");
    }
    public int createClaim(String claimDescription) throws Exception_Exception {

        return claim.createClaim(this.id, claimDescription);
    }
    public String claimToString(int claimId) {
        return claim.claimToString(this.id, claimId);
    }
    public int addDocument(String docContent, int claimId) {
        // encrypt data

        return claim.addDocument("client", claimId, docContent);
    }
    public String viewDocument(int claimID, int docID) {
        return claim.viewDocument("client", claimID, docID);
    }
    public String listDcouments(int claimID) {
        return claim.listDocuments("client", claimID);
    }
}
