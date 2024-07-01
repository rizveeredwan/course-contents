import java.io.*;
import java.net.*;

class SendingThread extends Thread{
    Socket socket; 
    public SendingThread(String threadName, Socket socket){
        super(threadName); 
        this.socket = socket; 
        start(); 
    }
    public void run(){
       try {
        ///System.out.println("came"); 
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // where to write and auto flush
        for(int i=1; i<=500; i++){
                System.out.println("Server sending: Hello from server! " + i);
                out.println("Hello from server! " + i);
                try{
                    Thread.sleep(1000);
                }
                catch(Exception e){
                    e.printStackTrace(); 
                }
        }
       // out.close(); 
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       }
       
    }
}

class ListeningThread extends Thread{
    Socket socket; 
    public ListeningThread(String threadName, Socket socket){
        super(threadName); 
        this.socket = socket; 
        start(); 
    }
    public void run(){
       try{
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         while(true){
            String message = in.readLine();
            System.out.println("Received message from client: " + message);
           }
       }
       catch(Exception e){
        e.printStackTrace(); 
       }
       //in.close(); 
    }
}


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Choose a port
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");
        // sending thread
        SendingThread st = new SendingThread("Sending Server", socket);
        // listening thread 
        ListeningThread lt = new ListeningThread("Listening server", socket); 
        // closing 
        //socket.close();
        //serverSocket.close();
    }
}