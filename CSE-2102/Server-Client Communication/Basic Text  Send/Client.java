import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // Server address and port 127.0.0.1
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = in.readLine();
        System.out.println("Received message from server: " + message);

        in.close();
        socket.close();
    }
}