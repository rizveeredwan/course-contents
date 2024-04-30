import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.util.Scanner;


import java.io.DataInputStream;
import java.io.FileInputStream;


public class FileReadBasics {
    static void usingBufferedReaderAndFileReader(){
        File file = new File("example.txt"); // location of the file [searching always starts from the current directory]
        // using buffered reader & File reader 
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void usingScanner(){
        try (Scanner scanner = new Scanner(new File("example.txt"))) { //System.in
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void usingStream(){
        try (DataInputStream dis = new DataInputStream(new FileInputStream("example.txt"))) {
            while(true){
                byte b [] = new byte[1024];
                int v  = dis.read(b);
                System.out.println(v);
                if(v == -1) break; 
                // String s = new String(b);
                // System.out.println(s);

                byte sb[] = new byte[v];
                for(int i=0; i<v; i++){
                     sb[i] = b[i];
                }
                String ns = new String(sb);
                System.out.println(ns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //usingBufferedReaderAndFileReader();
       // usingScanner();
        usingStream();
    }
}