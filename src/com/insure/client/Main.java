package com.insure.client;

//wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/docstorage?wsdl"

import com.insure.client.security.EncryptPub;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class Main {
    public static void main(String args[]) throws Exception {
        //Define ip
        String ip = JOptionPane.showInputDialog(null,"Please inform the IP to run the server", "localhost");
        if (ip == null) {return;}

        //login simulation
        String role = (String) JOptionPane.showInputDialog(null, "Please select your role: ", "Login",JOptionPane.QUESTION_MESSAGE, null, new String[]{"insured", "officer"}, "insured");
        int id = (int) JOptionPane.showInputDialog(null, "Please select your ID: ", "Login",JOptionPane.QUESTION_MESSAGE, null, new Integer[]{0,1,2,3,4,5,6,7,8,9}, 0);

        if(role == null) { return; }

        Client client = new Client(role, id, ip);

        String[] options = {"Create Claim", "Print claim information", "Add document to claim", "View document", "List documents", "Edit document", "Exit"};
        System.out.println("Log: ");

        while (true){
            String command = (String) JOptionPane.showInputDialog(null, "Select an option: ", "InSure claim management system",JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //End client execution block
            if (command == null || command.contentEquals("Exit")){
                return;

            //Add claim block
            }else if (command.contentEquals("Create Claim")){
                String description = JOptionPane.showInputDialog("Claim description: ");

                int claimId = -1;
                String error = null;
                try {
                    claimId = client.createClaim(description);
                } catch (Exception e){
                    error = e.getMessage();
                }

                if(claimId > -1) {
                    System.out.println("Your claim was successfully registered with the number " + claimId);
                    JOptionPane.showMessageDialog(null, "Your claim was successfully registered with the number " + claimId);
                } else {
                    System.out.println(error);
                    JOptionPane.showMessageDialog(null, error);
                }

            //Print claim information block
            } else if (command.contentEquals("Print claim information")){
                String sID = JOptionPane.showInputDialog("Please inform the claim ID you wish to print: ");
                //check if claim ID format is valid
                if (sID.matches("\\d+")) {

                    int claimId = Integer.parseInt(sID);
                    String claimContent = "";
                    try {
                        claimContent = client.claimToString(claimId);
                    } catch (Exception e) {
                        claimContent = e.getMessage();
                    }

                    System.out.println(claimContent);
                    JOptionPane.showMessageDialog(null, claimContent);
                } else {
                    System.out.println("This claim ID is not valid. It must be a number.");
                    JOptionPane.showMessageDialog(null, "This claim ID is not valid. It must be a number.");
                }

            //Add document to claim block
            } else if (command.contentEquals("Add document to claim")){
                String sID = JOptionPane.showInputDialog("Please inform the claim ID you wish add a document to : ");

                //check if claim id is valid
                if (sID.matches("\\d+")) {
                    int claimId = Integer.parseInt(sID);
                    String docContent = JOptionPane.showInputDialog("Document content: ");

                    int docID = -1;
                    String error = null;
                    try {
                        docID = client.addDocument(docContent, claimId);
                    } catch (Exception e) {
                        error = e.getMessage();
                    }

                    if (docID > -1) {
                        System.out.println("Your document was successfully registered with the number " + docID);
                        JOptionPane.showMessageDialog(null, "Your document was successfully registered with the number " + docID);
                    } else {
                        System.out.println(error);
                        JOptionPane.showMessageDialog(null, error);
                    }
                } else {
                    System.out.println("This claim ID is not valid. It must be a number.");
                    JOptionPane.showMessageDialog(null, "This claim ID is not valid. It must be a number.");
                }

            //View document block
            } else if (command.contentEquals("View document")){
                String sClaimID = JOptionPane.showInputDialog("Please inform the claim ID that contains the document you wish to view: ");
                String sDocID = JOptionPane.showInputDialog("Please inform the document ID you wish to view: ");

                //check if format of claimID is valid
                if(!sClaimID.matches("\\d+")){
                    System.out.println("This claim ID is not valid. It must be a number.");
                    JOptionPane.showMessageDialog(null, "This claim ID is not valid. It must be a number.");

                //check if format of document ID is valid
                } else if (!sDocID.matches("\\d+")) {
                    System.out.println("This document ID is not valid. It must be a number.");
                    JOptionPane.showMessageDialog(null, "This document ID is not valid. It must be a number.");

                }else{

                    int claimId = Integer.parseInt(sClaimID);
                    int docID = Integer.parseInt(sDocID);

                    String message = "";
                    try {
                        message = client.viewDocument(docID, claimId);
                    } catch (Exception e) {
                        message = e.getMessage();
                    }

                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, message);
                }

            } else if (command.contentEquals("List documents")){
                String sID = JOptionPane.showInputDialog("Please inform the claim ID from which you wish to list the documents: ");

                //check if format of claim ID is valid
                if (sID.matches("\\d+")) {
                    int claimId = Integer.parseInt(sID);

                    String message = "";
                    try {
                        message = client.listDocuments(claimId);
                    } catch (Exception e) {
                        message = e.getMessage();
                    }

                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, message);
                } else {
                    System.out.println("This document ID is not valid. It must be a number.");
                    JOptionPane.showMessageDialog(null, "This document ID is not valid. It must be a number.");
                }

            //Edit document block
            } else if (command.contentEquals("Edit document")){
                String sClaimID = JOptionPane.showInputDialog("Please inform the claim ID which the document is associated with: ");
                String sDocID = JOptionPane.showInputDialog("Please inform the document ID you wish to edit: ");

                //check if format of claimID is valid
                if(!sClaimID.matches("\\d+")){
                    System.out.println("This claim ID is not valid. It must be a number.");
                    JOptionPane.showMessageDialog(null, "This claim ID is not valid. It must be a number.");

                //check if format of document ID is valid
                } else if (!sDocID.matches("\\d+")) {
                    System.out.println("This document ID is not valid. It must be a number.");
                    JOptionPane.showMessageDialog(null, "This document ID is not valid. It must be a number.");

                }else {

                    int claimId = Integer.parseInt(sClaimID);
                    int docID = Integer.parseInt(sDocID);
                    String docContent = JOptionPane.showInputDialog("New content: ");

                    try {
                        client.editDocument(docID, docContent, claimId);
                        System.out.println("Document successfully edited!");
                        JOptionPane.showMessageDialog(null, "Document successfully edited!");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        }
    }
}