import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // Server address and port
        System.out.println("Connected to server.");

        InputStream in = socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] byteMessage = buffer.toByteArray();
        String textMessage = new String(byteMessage, "UTF-8");
        System.out.println("Received message from server: " + textMessage);

        in.close();
        socket.close();
    }
}
