package view;

import java.util.Scanner;

public class SaveView {
    private static final Scanner myScanner = new Scanner(System.in);

    public String getFilename() {
        // Message
        System.out.println("Please enter a filepath where you would like to save this calendar:");
        String filepath = myScanner.nextLine();

        return filepath;
    }

    public void display(String output) {
        System.out.println(output);
    }
}
