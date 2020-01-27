package com.insure.client;

import com.insure.client.gen.Claim;
import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;

import javax.xml.ws.BindingProvider;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/docstorage?wsdl"

public class Main {
    public static void main(String args[]) throws InterruptedException{
        ClaimDataStoreService cService = new ClaimDataStoreService();

        final ClaimDataStore claim = (ClaimDataStore) cService.getClaimDataStorePort();

        ((BindingProvider) claim).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8090/docstorage");

        System.out.println(claim.createClaim("Test!"));

    }

    public static void runService(){

    }
}
