package view;

import java.util.Scanner;

public class LoadView {
    private static final Scanner myScanner = new Scanner(System.in);

    public String getFilename() {
        // Message
        System.out.println("Please enter a filepath where the calendar you would like to load is located:");
        String filepath = myScanner.nextLine();

        return filepath;
    }

    public void display(String output) {
        System.out.println(output);
    }
}
