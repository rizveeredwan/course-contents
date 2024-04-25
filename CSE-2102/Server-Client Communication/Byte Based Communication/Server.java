import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        String textMessage = "Hello from server!";
        byte[] byteMessage = textMessage.getBytes("UTF-8"); // conversion in bytes to send the information 

        OutputStream out = socket.getOutputStream();
        out.write(byteMessage);

        out.close();
        socket.close();
        serverSocket.close();
    }
}