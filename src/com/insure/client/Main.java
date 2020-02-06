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

            if (command == null || command.contentEquals("Exit")){
                return;
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


            } else if (command.contentEquals("Print claim information")){
                int claimId = Integer.parseInt(JOptionPane.showInputDialog("Please inform the claim ID you wish to print: "));
                String claimContent = "";
                try {
                    claimContent = client.claimToString(claimId);
                } catch (Exception e){
                    claimContent = e.getMessage();
                }

                System.out.println(claimContent);
                JOptionPane.showMessageDialog(null, claimContent);


            } else if (command.contentEquals("Add document to claim")){
                int claimId = Integer.parseInt(JOptionPane.showInputDialog("Please inform the claim ID you wish add a document to : "));
                String docContent = JOptionPane.showInputDialog("Document content: ");

                int docID = -1;
                String error = null;
                try{
                    docID = client.addDocument(docContent, claimId);
                } catch (Exception e){
                    error = e.getMessage();
                }

                if(docID > -1){
                    System.out.println("Your document was successfully registered with the number " + docID);
                    JOptionPane.showMessageDialog(null, "Your document was successfully registered with the number " + docID);
                } else {
                    System.out.println(error);
                    JOptionPane.showMessageDialog(null, error);
                }


            } else if (command.contentEquals("View document")){
                int claimId = Integer.parseInt(JOptionPane.showInputDialog("Please inform the claim ID which the document is associated with: "));
                int docID = Integer.parseInt(JOptionPane.showInputDialog("Please inform the document ID you wish to view: "));

                String message = "";
                try {
                    message = client.viewDocument(docID, claimId);
                } catch (Exception e){
                    message = e.getMessage();
                }

                System.out.println(message);
                JOptionPane.showMessageDialog(null, message);

            } else if (command.contentEquals("List documents")){
                int claimId = Integer.parseInt(JOptionPane.showInputDialog("Please inform the claim ID that contains the document you wish to list: "));

                String message = "";
                try{
                    client.listDocuments(claimId);
                } catch (Exception e){
                    message = e.getMessage();
                }

                System.out.println(message);
                JOptionPane.showMessageDialog(null, message);

            } else if (command.contentEquals("Edit document")){
                int claimId = Integer.parseInt(JOptionPane.showInputDialog("Please inform the claim ID which the document is associated with: "));
                int docID = Integer.parseInt(JOptionPane.showInputDialog("Please inform the document ID you wish to view: "));
                String docContent = JOptionPane.showInputDialog("New content: ");

                try {
                    client.editDocument(docID, docContent, claimId);
                    System.out.println("Document successfully edited!");
                    JOptionPane.showMessageDialog(null, "Document successfully edited!");
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }


            }
        }
    }
}