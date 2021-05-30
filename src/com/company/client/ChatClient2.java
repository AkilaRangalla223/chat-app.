package com.company.client;

import java.io.IOException;
import java.util.Scanner;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {

       // System.out.println("Client is connected");
        Client client = new Client();
        client.start();

/*
        client.sendMessage("Hello");
        client.sendMessage("How are you?");
        client.sendMessage("Sachintha");
*/

        Scanner scanner = new Scanner(System.in);  // Creating a Scanner object



        while (true){
            String message1 = scanner.nextLine();  // Reading the user input
            client.sendMessage(message1); // Sending user input
        }




    }
}
