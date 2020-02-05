package com.insure.client;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/docstorage?wsdl"

import com.insure.client.security.EncryptPub;

public class Main {
    public static void main(String args[]) throws Exception {

        //testar todos os métodos

        // testar cliente adiciona doc, officer altera doc, cliente veê doc

        //testar em multihtread

        Client insured = new Client("insured", 1);
        int id = insured.createClaim("Test claim");
        System.out.println(insured.claimToString(id));
        int doc = insured.addDocument("Documento de teste", id);

        Client officer = new Client("officer", 0);
        officer.editDocument(doc, "Documento alterado", id);
        System.out.println(insured.viewDocument(doc, id));



    }

}