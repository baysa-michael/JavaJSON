package model;

import java.util.GregorianCalendar;

public class Appointment {
    private GregorianCalendar date;
    private String description;
    private String appointmentHash;

    public Appointment() {
        this.date = new GregorianCalendar();
        this.description = "ERROR";
    }

    public Appointment(GregorianCalendar date, String description) {
        this.date = date;
        this.description = description;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getAppointmentHash() {
        return appointmentHash;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAppointmentHash(String appointmentHash) {
        this.appointmentHash = appointmentHash;
    }
}


