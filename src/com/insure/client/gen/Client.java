package com.insure.client.gen;

import javax.xml.ws.BindingProvider;

public class Client {
    public Client(){
        int number;

        ClaimDataStoreService cService = new ClaimDataStoreService();

        final ClaimDataStore claim = (ClaimDataStore) cService.getClaimDataStorePort();

        ((BindingProvider) claim).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8090/docstorage");

        number = claim.connect();

        System.out.println(number);

        System.out.println("Claim registered successfully with the number: " + claim.createClaim("Test!"));

    }
}
