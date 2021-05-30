package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(6_000);
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            String name="";
            String inputData;

            while ((inputData = bufferedReader.readLine()) != null){

                System.out.println("Data From Client: "+inputData);

                switch (inputData) {

                    case "Hello" :
                        outputStream.writeBytes("Hello from the Server\n");
                        break;
                    case "How are you?" :
                        outputStream.writeBytes("Good! What is your Name\n");
                        break;
                    case "Start" :
                        outputStream.writeBytes("Welcome to the server, " + name + "\n");
                        break;
                    default :
                        if(inputData.equals("exit")){
                            outputStream.writeBytes("Bye" + "\n");
                            break;
                        }
                        outputStream.writeBytes( "Type Start when you're ready!" + "\n");
                        name = inputData;}




            }

            client.close();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }



    }
}
