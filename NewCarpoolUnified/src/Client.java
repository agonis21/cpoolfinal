import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static boolean isDisconnected= false;


    public Client(){}

    public static void run(Requests request) {

        String messageIn = "";
        String messageOut = "";

        try {

            System.out.println("----------*** This is client side ***--------");
            System.out.println("client started!");
            //connect the client socket to server

            //NEED TO CHANGE
            Socket socket = new Socket("localhost", 9806);


            //client reads a message from Server
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            //CHANGE TEST1 TO OBJECT IN RUN
            objectOutputStream.writeObject(request);


            if(isDisconnected)
            {
                messageOut = "exit";
                outputStream.writeUTF(messageOut);
            }




            while(!messageIn.equals("exit")) {
                messageIn = inputStream.readUTF();
                // client prints the message received from server to console
                System.out.println("message received from server: " + "\"" + messageIn + "\"");


                // ********************************************************
                // client reads a message from keyboard
                System.out.println("Enter a message you want to send to server side: ");

                messageOut = "test";
                // server sends the message to client
                outputStream.writeUTF(messageOut);

            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
