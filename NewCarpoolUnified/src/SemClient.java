import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SemClient extends ClientVCC implements Runnable {
    private Thread t;
    private String threadName;


    String requestDetails;
    public SemClient(){
        super();
    }
    public SemClient(String request) throws IOException, ClassNotFoundException {
        super();

        this.requestDetails = request;
        this.threadName = this.requestDetails;

        this.start();

    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 9806);

            System.out.println("Connected to server.");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            boolean flag = true;

//            while ((userInput = stdIn.readLine()) != null) {
//                ArrayList<String> str = new ArrayList<String>();
//
//                out.writeObject(userInput);
//                Object serverResponse = in.readObject();
//                System.out.println("Received response from server: " + serverResponse.toString());
//
//                flag = false;
//            }

            System.out.println(":" + this.requestDetails);
            out.writeObject(this.requestDetails);
            Object serverResponse = in.readObject();
            System.out.println("Received response from server: " + serverResponse.toString());
            super.updateStatus( serverResponse.toString());

            in.close();
            out.close();
            stdIn.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}