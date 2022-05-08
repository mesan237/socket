import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(int port) throws Exception{
        ServerSocket server = new ServerSocket(port);
        System.out.println("Waiting for a connetion...");

        Socket socket = server.accept();
        System.out.println("The client "+ socket.getInetAddress() + " has connected");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new PrintWriter(socket.getOutputStream()), true);

        out_socket.println("Welcome client");
        String message = in_socket.readLine();
        System.out.println("The client says : "+ message);

        socket.close();
        System.out.println("The socket is closed");


    }

    public static void main(String[] args) {
        try {
            new Server(2022);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
