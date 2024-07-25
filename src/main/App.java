package main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class App {
    private static StringBuilder jsonContent;

    /**
     * 
     * Reads the content of a JSON file from the specified path and returns it as a
     * 'StringBuilder'.
     * 
     * This method opens the file located at the given path, reads its contents line
     * by line, and
     * appends each line (with leading and trailing whitespace removed) to a
     * 'StringBuilder' object.
     * The resulting 'StringBuilder' contains the entire content of the file in a
     * continuous
     * string format, which is further used for processing and validation.
     * 
     * @param path The path to the JSON file to be read.
     * 
     * @return A 'StringBuilder' containing the trimmed content of the file.
     *         If an exception occurs, the method will return 'null'.
     */
    public static StringBuilder readJsonFile(String path) {
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line.trim());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
        return jsonContent;
    }

    public static void processJsonFile(String path) {
        readJsonFile(path);
        Lexar lexar = new Lexar();
        Parser parser = new Parser(lexar);

        boolean isValid = parser.parseObject();
        if (isValid) {
            System.out.println("Valid JSON");
            System.exit(0);
        } else {
            System.out.println("Invalid JSON");
            System.exit(1);
        }
    }

    public static StringBuilder getJsonContent() {
        return jsonContent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        readJsonFile(path);

    }
}
