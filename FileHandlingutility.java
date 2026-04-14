import java.io.*;
import java.util.*;

public class FileHandlingutility {

    // Method to write to file
    public static void writeFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("Hello Everyone!\n");
            writer.write("This is a Java File Handling utility.\n");
            writer.write("let's get into it!");
            writer.close();
            System.out.println("File written successfully.\n");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    // Method to read from file
    public static void readFile(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            System.out.println("Reading File Content:\n");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // Method to modify file content
    public static void modifyFile(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            StringBuilder content = new StringBuilder();

            // Read existing content
            while (reader.hasNextLine()) {
                content.append(reader.nextLine()).append("\n");
            }
            reader.close();

            // Modify content (replace word)
            String modifiedContent = content.toString().replace("Java", "Advanced Java");

            // Write updated content back
            FileWriter writer = new FileWriter(filename);
            writer.write(modifiedContent);
            writer.close();

            System.out.println("File modified successfully.\n");

        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }

    public static void main(String[] args) {
        String filename = "demo.txt";

        writeFile(filename);
        readFile(filename);
        modifyFile(filename);
        readFile(filename);
    }
}