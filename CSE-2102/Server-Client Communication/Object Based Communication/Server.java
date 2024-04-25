import java.io.*;
import java.net.*;

class MyObject implements Serializable {
    private int id;
    private String name;
    public MyObject(int id, String name) {
        this.id = id;
        this.name = name; 
    }
    // Constructor, getters, and setters
    public int getId() {
        return this.id; 
    }
    public String getName() {
        return this.name; 
    }
}



public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        MyObject objToSend = new MyObject(1, "Example");
        out.writeObject(objToSend);
        
        out.close();
        socket.close();
        serverSocket.close();
    }
}
