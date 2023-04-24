import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends AdminVCC implements Runnable{
    private Thread t;
    private String threadName;

	/*
	    ==============MILESTONE 5================
		This class will need to be modified in order to add requests to the cloud controller request queue
		1- method to send accept message back to client
		2- method to send reject message back to client
	 */



    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static Requests recieved;
    private boolean approved;

    ObjectOutputStream out;

    String messageIn = "";
    String messageOut = "";
    public Server(){
        super();
    }

    public Server( String name) {
        super();
        threadName = name;
        System.out.println("Creating " +  threadName );

        //super.updateRequestInfo("dfafdafdsafdsf");

        super.AcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAccepted(true);
                respond();
            }
        });
        super.DeclineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAccepted(false);
                respond();
            }
        });
    }

    public boolean isAccepted(Boolean approved){
        return this.approved=approved;
    }
    public  void run() {
        System.out.println("Running " +  threadName );

        try {

            System.out.println("----------$$$ This is server side $$$--------");
            System.out.println("wating for client to connect...");
            // creating the server
            serverSocket = new ServerSocket(9806);
            // sever accepts connection request from client
            socket = serverSocket.accept();
            System.out.println("client is connected!");


            out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
//be able to take multiple messages in while loop
            Object inputObject;
            while ((inputObject = in.readObject()) != null) {
                System.out.println("Received message from client: " + inputObject.toString());
                super.updateRequestInfo(inputObject.toString()); //takes userEntry

                int result = super.showPopUp();

                if(result == JOptionPane.YES_OPTION){
                    out.writeObject("Accepted");
                }else if (result == JOptionPane.NO_OPTION){
                    out.writeObject("Rejected");
                }else {
                    out.writeObject("Undetermined");
                }


                super.updateRequestInfo(inputObject.toString());

            }

            System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
            in.close();
            out.close();
            socket.close();

//            // server reads a message message from client
//            inputStream = new DataInputStream(socket.getInputStream());
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            readMessageMethod();
//
//            // server sends a message to client
//            outputStream = new DataOutputStream(socket.getOutputStream());
//            recieved = (Requests) objectInputStream.readObject();
//            System.out.println(recieved.jobRequest.jobType);
//            writeMessageMethod();


            // as long as message is not exit keep reading and sending message to client
           /* while (!messageIn.equals("exit")) {


                // extract the message from client
                messageIn = inputStream.readUTF();
                // server prints the message received from client to console
                System.out.println("message received from client: " + "\"" + messageIn + "\"");

                // ********************************************************

                //System.out.println("Enter a message you want to send to client side: ");

                if(isAccepted == true)
                {
                    messageOut = "Your request has been accepted!";
                }
                else
                {
                    messageOut = "Your request has been rejected.";
                }

                // server sends the message to client
                outputStream.writeUTF(messageOut);
            }
        */

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void readMessageMethod() {
        // server reads a message message from client
        super.updateRequestInfo("dfafdafdsafdsf");
    }

    private void writeMessageMethod() {
        // server sends a message to client

    }

    public void respond () {
        try {
            if (approved == true) {
                messageOut = "Your request has been accepted!";
            } else {
                messageOut = "Your request has been rejected.";
            }

            System.out.println("RESSSSS");
            out.writeObject(messageOut);

            //outputStream.writeUTF(messageOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

}





