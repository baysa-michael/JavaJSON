package view;

import model.Appointment;
import model.UserCalendar;

import java.util.ArrayList;
import java.util.List;

public class DisplayView {
    public void display(Object calendarObject) {
        UserCalendar calendar = (UserCalendar) calendarObject;
        // Message
        System.out.println("\n>>>>>CALENDAR DETAILS");
        System.out.println("Calendar Owner:  " + calendar.getOwner());

        // Loop through and display all appointments
        List<Appointment> appointments = calendar.getAppointments();
        for (int i = 0; i < calendar.getAppointments().size(); i++) {
            System.out.println("------------------------------");
            System.out.println("Date:  " + appointments.get(i).getDate().getTime());
            System.out.println("Description:  " + appointments.get(i).getDescription());
            System.out.println("Hash:  " + appointments.get(i).getAppointmentHash());
            System.out.println("------------------------------");
        }

        System.out.println("\n>>>>>END OF CALENDAR\n");
    }
}
