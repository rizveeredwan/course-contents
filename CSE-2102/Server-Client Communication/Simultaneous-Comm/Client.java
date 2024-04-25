import java.io.*;
import java.net.*;

class SendingClient extends Thread{
    Socket socket; 
    public SendingClient(String threadName, Socket socket){
        super(threadName); 
        this.socket = socket; 
        start(); 
    }
    public void run(){
       try {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // where to write and auto flush
        for(int i=1; i<=500; i++){
                System.out.println("Client sending: Hello from client! " + i);
                out.println("Hello from client! " + i);
                try{
                    Thread.sleep(1000);
                }
                catch(Exception e){
                    e.printStackTrace(); 
                }
        }
        out.close(); 
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       }
       
    }
}

class ListeningClient extends Thread{
    Socket socket; 
    public ListeningClient(String threadName, Socket socket){
        super(threadName); 
        this.socket = socket; 
        start(); 
    }
    public void run(){
       try{
         while(true){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            System.out.println("Received message from server: " + message);
            //in.close(); 
           }
       }
       catch(Exception e){
        e.printStackTrace(); 
       }
       //in.close(); 
    }
}

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // Server address and port
        System.out.println("Connected to server.");
        
        SendingClient sc = new SendingClient("SendingClient", socket);
        ListeningClient lc = new ListeningClient("ListeningClient", socket);

        //socket.close();
    }
}