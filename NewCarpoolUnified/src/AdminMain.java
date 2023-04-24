import java.io.IOException;

public class AdminMain {


    public static void main(String[] args) throws IOException {
        Server server = new Server("server-1");
        //AdminVCC adminVCC = new AdminVCC();


        server.start(9806);
        //adminVCC.server.start();

        //adminVCC.updateRequests("aaaaaaaaa");



    }

}
