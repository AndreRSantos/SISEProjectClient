package com.insure.client;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/docstorage?wsdl"

import com.insure.client.security.EncryptPub;

public class Main {
    public static void main(String args[]) throws Exception {

        //testar todos os métodos

        // testar cliente adiciona doc, officer altera doc, cliente veê doc

        //testar em multihtread


       try {
            Client insured0 = new Client("notexisting", 0);

            int claimID = insured0.createClaim("Test claim");

            int docID = insured0.addDocument("Document 1", claimID);
            System.out.println(insured0.claimToString(claimID));
            System.out.println(insured0.listDocuments(claimID));
            System.out.println("View" + insured0.viewDocument(docID, claimID));


            insured0.addDocument("Document 2", claimID);

            System.out.println(insured0.claimToString(claimID));
        } catch (ClientException e){
            System.out.println("Client Exception");
        }

        //testing several clients


        Thread c0 = new insuredThread("client", 0);
        Thread c1 = new insuredThread("client",1);
        Thread c2 = new insuredThread("client",2);

        c0.start();
        c1.start();
        c2.start();

        c0.join();
        c1.join();
        c2.join();


    }

    //insure thread (for testing)

    static class insuredThread extends Thread{
        private int id;
        private String role;

        public insuredThread(String role, int id){
            this.id = id;
            this.role = role;
        }

        public void run(){
            try {
               Client client1=new Client(this.role, this.id);


            } catch (ClientException e)  {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}