package football;

// Handling user input

import java.util.Scanner;
import java.util.ArrayList;

public class InputHandler
{
    // Simple String input - no checks

    public static String getString()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    // String input - only accepting inputs specified in ArrayList parameter

    public static String getString(ArrayList<String> options, String errorMessage)
    {
        while(true)
        {
            String input = getString();
            if(options.contains(input)) return input;
            else System.out.print(errorMessage);
        }
    }

    // String input - only accepting inputs specified in Array parameter

    public static String getString(String[] options, String errorMessage)
    {
        while(true)
        {
            String input = getString();
            for(String option : options)
            {
                if(input.equals(option)) return input;
            }
            System.out.print(errorMessage);
        }
    }

    public static int getInt(String errorMessage)
    {
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt())
        {
            input.nextLine();
            System.out.print(errorMessage);
        }
        return input.nextInt();
    }

    public static int getInt(int min, int max, String typeErrorMessage, String rangeErrorMessage)
    {
        while(true)
        {
            int value = getInt(typeErrorMessage);
            if(value >= min && value <= max) return value;
            else System.out.print(rangeErrorMessage);
        }
    }

    public static int getInt(ArrayList<Integer> options, String errorMessage, String valueErrorMessage)
    {
        while(true)
        {
            Integer value = (getInt(errorMessage));
            if(options.contains(value)) return value;
            else System.out.print(valueErrorMessage);
        }
    }

    public static int getInt(ArrayList<Integer> options, String errorMessage)
    {
        while(true)
        {
            Integer value = (getInt(errorMessage));
            if(options.contains(value)) return value;
            else System.out.print(errorMessage);
        }
    }
}
