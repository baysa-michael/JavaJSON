package control;

import model.Appointment;
import model.UserCalendar;
import view.WelcomeView;

import java.util.HashMap;

public class MasterController {
    private ApplicationController myAppController;
    private HashMap<String, Object> data;

    public MasterController() {
        // Initialize Application Controller
        this.myAppController = new ApplicationController();
        initializeAppController();

        // Initialize Data Hash Map
        data = new HashMap<String, Object>();

        //Initialize User Calendar
        UserCalendar userCalendar = new UserCalendar();
            for(Appointment appointment : userCalendar.getAppointments()) {
                try {
                appointment.setAppointmentHash(new SetHandler().calculateHash(appointment.getDate(),
                        appointment.getDescription()));
                } catch (Exception e){
                    appointment.setAppointmentHash("HASHERROR");
                }
            }

        data.put("endProgram", true);
        data.put("calendar", userCalendar);
    }

    public MasterController(UserCalendar userCalendar) {
        // Initialize Application Controller
        this.myAppController = new ApplicationController();
        initializeAppController();

        // Initialize Calendar Hash
        for(Appointment appointment : userCalendar.getAppointments()) {
            try {
                appointment.setAppointmentHash(new SetHandler().calculateHash(appointment.getDate(),
                        appointment.getDescription()));
            } catch (Exception e){
                appointment.setAppointmentHash("HASHERROR");
            }
        }

        // Initialize Data Hash Map
        data = new HashMap<String, Object>();

        //Initialize User Calendar
        data.put("continueProgram", true);
        data.put("calendar", userCalendar);
    }

    private void initializeAppController() {
        this.myAppController.addCommand("Set", new SetHandler());
        this.myAppController.addCommand("Display", new DisplayHandler());
        this.myAppController.addCommand("Exit", new ExitHandler());
    }

    public void launchProgram() {
        // Display Welcome View
        WelcomeView welcome = new WelcomeView();
        String userResponse;

        // Action Loop based on User Responses
        do {
            // Get User Response for Action
            userResponse = welcome.display();

            myAppController.handleRequest(userResponse, data);
        } while ((boolean) data.get("continueProgram"));
    }
}
