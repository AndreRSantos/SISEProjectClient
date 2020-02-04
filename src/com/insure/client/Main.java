package com.insure.client;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://146.193.7.121:8090/docstorage?wsdl"

import com.insure.client.security.EncryptPriv;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String args[]) throws Exception {

        //teste de encriptacao
        Client insured0 = new Client("insured", 0);


        try {
            int claimId = insured0.createClaim("test de assinatura");
            System.out.println(insured0.claimToString(claimId));
        } catch (Exception e){
            System.out.println(e);
        }


       /* try {
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
        }*/

        //testing several clients

        /*
        Thread c0 = new insuredThread(0);
        Thread c1 = new insuredThread(1);
        Thread c2 = new insuredThread(2);

        c0.start();
        c1.start();
        c2.start();

        c0.join();
        c1.join();
        c2.join();
        */

    }

    //insure thread (for testing)
    static class insuredThread extends Thread{
        private int id;

        public insuredThread(int id){
            this.id = id;
        }

        public void run(){
            try {
               //Client client0 = new Client("role", this.id);
               Client client1=new Client("officer", 1);

                int claimID = client1.createClaim("Test claim ");

                int docID= client1.addDocument("Document 1 from insured" + this.id, claimID);
                System.out.println(this.id + "_thread: " + client1.claimToString(claimID));
                System.out.println(this.id + "_thread: " + client1.listDocuments(claimID));
                System.out.println(this.id + "_thread: " + "View"+ client1.viewDocument(docID,claimID));


                client1.addDocument("Document 2 frm insured" + this.id, claimID);
                client1.editDocument(docID,"New document",claimID);
                System.out.println(client1.viewDocument(docID,claimID));


                System.out.println(this.id + "_thread: " + client1.claimToString(claimID));
            } catch (ClientException e)  {
                System.out.println("Client Exception");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}