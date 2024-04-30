import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteBasics {
    static void usingBufferwriter(){
        File file = new File("output.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // true (append) vs false (new file)
            writer.write("Hello, World!");
            writer.write("Hello, World!"); // same line or line shift ? 
            writer.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void usingDirectFileWriter(){
        String fileName = "output.txt";
        String textToAppend = "This text will be appended to the file.";

        try (FileWriter writer = new FileWriter(fileName, true)) { // Append mode enabled with 'true' as the second argument
            writer.write(textToAppend);
            writer.write(System.lineSeparator()); // Add a newline after the appended text
            System.out.println("Text appended to the file.");
        } catch (IOException e) {
            System.err.println("Error appending text to the file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
       usingBufferwriter();
       //usingDirectFileWriter(); 
    }
}