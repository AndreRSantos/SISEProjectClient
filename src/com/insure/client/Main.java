package com.insure.client;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://146.193.7.121:8090/docstorage?wsdl"

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Client insured0 = new Client("notexisting", 0);

        int claimID = insured0.createClaim("Test claim");

        int docID=insured0.addDocument("Document 1", claimID);
        System.out.println(insured0.claimToString(claimID));
        System.out.println(insured0.listDocuments(claimID));
        System.out.println("View"+insured0.viewDocument(docID,claimID));


        insured0.addDocument("Document 2", claimID);

        System.out.println(insured0.claimToString(claimID));

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
            Client client0 = new Client("role", this.id);

            int claimID = client0.createClaim("Test claim " + this.id);

            int docID= client0.addDocument("Document 1 from insured" + this.id, claimID);
            System.out.println(this.id + "_thread: " + client0.claimToString(claimID));
            System.out.println(this.id + "_thread: " + client0.listDocuments(claimID));
            System.out.println(this.id + "_thread: " + "View"+ client0.viewDocument(docID,claimID));


            client0.addDocument("Document 2 frm insured" + this.id, claimID);

            System.out.println(this.id + "_thread: " + client0.claimToString(claimID));
        }
    }

}