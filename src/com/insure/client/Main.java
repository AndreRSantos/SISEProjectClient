package com.insure.client;

//wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/docstorage?wsdl"

import com.insure.client.security.EncryptPub;

import javax.swing.*;

public class Main {
    public static void main(String args[]) throws Exception {

        //start main class
        String[] options = {"option1", "option2"};

        String command = (String) JOptionPane.showInputDialog(null, "message", "title",JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    }
}