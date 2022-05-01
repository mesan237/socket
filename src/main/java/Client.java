import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public Client(String host, int port) throws  Exception{
        Socket socket = new Socket(host, port);

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new PrintWriter(socket.getOutputStream()), true);

        String message = in_socket.readLine();
        System.out.println("The Server says : "+ message);
        out_socket.println("Thank you");

        socket.close();
        System.out.println("The socket is closed");
    }

    public static void main(String[] args) {
        try {
            new Client("10.0.2.5", 2022);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
