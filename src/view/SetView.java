package view;

import model.Appointment;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class SetView {
    private static final Scanner myScanner = new Scanner(System.in);

    public void display(Appointment newAppointment) {
        boolean validDate = false;
        int year;
        int month;
        int day;

        // Message
        do {
            // Gather User Input
            System.out.println("\nSET NEW APPOINTMENT");
            System.out.println("Please enter the date of your appointment in the following order:");
            System.out.print("YEAR:  ");
            year = myScanner.nextInt();
            System.out.print("MONTH:  ");
            month = myScanner.nextInt();
            System.out.print("DAY OF MONTH:  ");
            day = myScanner.nextInt();

            // Confirm validity of input
            if(year >= -9999 && year <= 9999){
                int maxDay;
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        maxDay = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        maxDay = 30;
                        break;
                    case 2:
                        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                            maxDay = 29;
                        } else {
                            maxDay = 28;
                        }
                        break;
                    default:
                        maxDay = 0;
                }

                if (day > 0 && day <= maxDay) {
                    validDate = true;
                } else {
                    System.out.println("ERROR:  Invalid Date - Please enter valid date parameters");
                }

            }
        } while (!validDate);

        // Adjust month to proper index
        month--;

        // Convert to Gregorian Date
        GregorianCalendar gregDate = new GregorianCalendar(year, month, day);

        // Prompt for Description
        String description;
        System.out.println("Please enter a brief description of your appointment:");
        myScanner.nextLine();
        description = myScanner.nextLine();

        // Update the new appointment
        newAppointment.setDate(gregDate);
        newAppointment.setDescription(description);
    }
}
