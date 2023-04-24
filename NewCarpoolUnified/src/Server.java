import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends AdminVCC {
    public String threadName;
    private ServerSocket serverSocket;

    public Server (String threadName){
        super();
        this.threadName = threadName;
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Create a new thread to handle the client
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clientHandler.start();
        }
    }

    public String decisionPopUp(String requestInfo){
        super.updateRequestInfo(requestInfo); //takes userEntry

        int result = super.showPopUp();

        if(result == JOptionPane.YES_OPTION){
            return "Accepted";


        }else if (result == JOptionPane.NO_OPTION){
            return "Rejected";
        }else {
            return "Undetermined";
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private ObjectInputStream inputStream;
        private ObjectOutputStream outputStream;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            this.outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            this.inputStream = new ObjectInputStream(clientSocket.getInputStream());
        }

        public void run() {
            try {
                while (true) {
                    // Read object from client
                    Object object = inputStream.readObject();
                    System.out.println("Received from client: " + object.toString());
                    //super.updateRequestInfo(inputObject.toString());

                    String decision = Server.this.decisionPopUp(object.toString());
                    if (decision == "Accepted"){
                        outputStream.writeObject("Accepted");
                        saveEntryToDatabase(object.toString());

                    }else if (decision == "Rejected"){
                        outputStream.writeObject("Rejected");
                    }else {
                        outputStream.writeObject("Undetermined");
                    }

                    // Send response back to client
                    outputStream.writeObject("Server response: " + object.toString());
                    outputStream.flush();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                    outputStream.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private String determineEntryType(String entry){
        String[] entryArr = entry.split(",");

        if (entryArr.length == 7) {
            return "job";
        } else {
            return  "vehicle";
        }
    }

    private void saveEntryToDatabase(String entry) {
        String entryType = determineEntryType(entry);

        if (entryType == "job"){

            //JobDBAccess.insert(dummyJob);
        } else {
            //VehicleDBAccess.insert(dummyVehicle);
        }

        System.out.println("Successfully saved to database!");
    }

    public static void main(String[] args) throws IOException {
//        Server server = new Server();
//        server.start(8080);
    }
}