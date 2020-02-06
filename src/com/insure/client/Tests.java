package com.insure.client;

public class Tests {
    public static void main(String args[]) throws Exception {

        Client insured = new Client("insured", 0, "localhost");
        Client insured2= new Client("insured",1, "localhost");
        int id = insured.createClaim("Test claim");
        System.out.println(insured.claimToString(id));
        int doc = insured.addDocument("Documento de teste", id);
        int doc2= insured.addDocument("Documento de teste 2",id);

        Client officer = new Client("officer", 0, "localhost");
        officer.editDocument(doc, "Documento alterado", id);
        System.out.println(officer.claimToString(id));
        System.out.println(insured.viewDocument(doc, id));
        System.out.println(insured.viewDocument(doc2,id));
        System.out.println(insured.listDocuments(id));
        System.out.println(officer.listDocuments(id));


        //Multithread testing

        Thread c0 = new insuredThread("client", 2,1);
        Thread c1 = new insuredThread("client",3,2);
        Thread c2 = new insuredThread("client",4,3);

        c0.start();
        c1.start();
        c2.start();

        c0.join();
        c1.join();
        c2.join();
    //Thread Creation
    }
    static class insuredThread extends Thread{
        private int id;
        private int oid;
        private String role;

        public insuredThread(String role, int id, int oid){
            this.id = id;
            this.role = "insured";
            this.oid=oid;
        }

        public void run(){
            Client client1= null;
            try {
                client1 = new Client(this.role, this.id, "localhost");
            } catch (ClientException e) {
                e.printStackTrace();
            }
            int id = 0;
            try {
                id = client1.createClaim("Test claim");
            } catch (Exception e) {
                e.printStackTrace();
            }
            int doc = 0;
            try {
                doc = client1.addDocument("Documento de teste", id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Client officer = null;
            try {
                officer = new Client("officer", oid, "localhost");
            } catch (ClientException e) {
                e.printStackTrace();
            }
            try {
                officer.editDocument(doc, "Documento alterado",id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
