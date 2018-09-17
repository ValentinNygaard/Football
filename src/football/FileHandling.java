package football;

// Handling file reading and writing

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileHandling {

    // Reading from file

    public static String readFile(String fileName) {
        String fileData = "";
        try
        {
            Scanner input = new Scanner(new File(fileName));

            while (input.hasNextLine())
            {
                fileData += input.nextLine() + '\n';
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        return fileData;
    }

    // Writing to file

    public static void writeFile(String newDataString, String fileName) {
        try
        {
            PrintStream output = new PrintStream(new File(fileName));
            output.println(newDataString);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

}
