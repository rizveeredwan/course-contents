import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept(); // blocking call 
        System.out.println("Client connected.");
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // where to write and auto flush 
        out.println("Hello from server!");

        // closing 
        out.close();
        socket.close();
        serverSocket.close();
    }
}