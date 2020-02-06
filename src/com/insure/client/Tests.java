package com.insure.client;

public class Tests {
    public static void main(String args[]) throws Exception {

        //testar todos os métodos

        // testar cliente adiciona doc, officer altera doc, cliente veê doc

        //testar em multihtread

        Client insured = new Client("insured", 1);
        int id = insured.createClaim("Test claim");
        int doc = insured.addDocument("Documento de teste", id);
        System.out.println(insured.viewDocument(doc, id));


        Client insured2= new Client("insured",2);
        System.out.println(insured.claimToString(id));

        int doc2= insured.addDocument("Documento de teste 2",id);

        Client officer = new Client("officer", 0);
        officer.editDocument(doc, "Documento alterado", id);
        System.out.println(officer.claimToString(id));
        System.out.println(insured.viewDocument(doc, id));
        System.out.println(insured.viewDocument(doc2,id));
        System.out.println(insured.listDocuments(id));
        System.out.println(officer.listDocuments(id));
        //insured2.editDocument(doc,"Fail",id);




    }
}
