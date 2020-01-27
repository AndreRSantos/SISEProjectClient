package com.insure.client;

import com.insure.client.gen.Claim;
import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;

import javax.xml.ws.BindingProvider;

public class Main {
    public static void main(String args[]) throws InterruptedException{
        ClaimDataStoreService cService = new ClaimDataStoreService();

        final ClaimDataStore claim = (ClaimDataStore) cService.getClaimDataStorePort();

        ((BindingProvider) claim).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://146.193.7.111:8090/docstorage");

        System.out.println(claim.checkIfWorking());

    }

    public static void runService(){

    }
}
