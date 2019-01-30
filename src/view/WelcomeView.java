package view;

import java.util.Scanner;

public class WelcomeView {
    private static final Scanner myScanner = new Scanner(System.in);

    public WelcomeView() {
    }

    public String display() {
        boolean validInput;
        String response;
        do {
            // Welcome & Prompt
            System.out.println("Welcome to the Business Scheduler!");
            System.out.println("Please enter a keyword from the options below:");
            System.out.println("(Set)     Set Appointments");
            System.out.println("(Display) Display Appointments");
            System.out.println("(Exit)    Exit");
            System.out.print("Selection:  ");

            // Get User Input
            response = myScanner.nextLine();

            System.out.println("\n");

            switch (response) {
                case "Set":
                case "Display":
                case "Exit":
                    validInput = true;
                    break;
                default:
                    System.out.println("ERROR:  Invalid Response - Please select a valid response letter\n\n");
                    validInput = false;
            }

            System.out.println(response);
        } while (!validInput);

        return response;
    }
}
