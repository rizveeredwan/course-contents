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


public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 12345); // Server address and port
        System.out.println("Connected to server.");

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        MyObject receivedObj = (MyObject) in.readObject();
        System.out.println("Received object: " + receivedObj.getId() + ", " + receivedObj.getName());

        in.close();
        socket.close();
    }
}