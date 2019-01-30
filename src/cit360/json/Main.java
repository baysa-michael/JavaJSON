package cit360.json;

import control.MasterController;
import model.Appointment;
import model.UserCalendar;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create initial seed data
        List<Appointment> testAppointment = new ArrayList<Appointment>();
        testAppointment.add(new Appointment(new GregorianCalendar(2019, 1, 5), "Chinese New Years"));

        UserCalendar calendar = new UserCalendar("Michael", testAppointment);
        MasterController newMaster = new MasterController(calendar);

        newMaster.launchProgram();
    }
}
