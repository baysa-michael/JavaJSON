package control;

import model.Appointment;
import model.UserCalendar;
import view.SetView;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class SetHandler implements Handler{
    public void execute(HashMap<String, Object> data) {
        // Create a new appointment container
        Appointment newAppointment = new Appointment();

        // Gather Appointment information from the user
        SetView newSet = new SetView();
        newSet.display(newAppointment);

        // Add a hash for the appointment
        try {
            newAppointment.setAppointmentHash(calculateHash(newAppointment.getDate(), newAppointment.getDescription()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Add this new appointment to the calendar
        List<Appointment> newAppointmentList = ((UserCalendar) data.get("calendar")).getAppointments();
        newAppointmentList.add(newAppointment);
        UserCalendar newCalendar = ((UserCalendar) data.get("calendar"));
        newCalendar.setAppointments(newAppointmentList);
        data.replace("calendar", newCalendar);

        System.out.println("\nAppointment Successfully Added\n");
    }

    public static String calculateHash(GregorianCalendar inputDate, String inputDescription) throws Exception {
        // Concatenate the Date and Description
        String combinedString = inputDate.toString() + inputDescription;

        // Get an instance of the SHA-256 algorithm
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Create Byte Array
        byte[] byteArray = digest.digest(combinedString.getBytes("UTF-8"));

        // Create a new hex string
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            String hex = Integer.toHexString(0xff & byteArray[i]);
            if (hex.length() == 1) { hexString.append('0'); }
            hexString.append(hex);
        }

        return hexString.toString();
    }


/*
// Recalculate Hash
        try {
                this.appointmentHash = calculateHash(this.date, this.description);
                } catch (Exception e)
                {
                appointmentHash = "HASHERROR";
*/
}
