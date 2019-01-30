package model;

import java.util.List;

public class UserCalendar {
    private String owner;
    private List<Appointment> appointments;

    public UserCalendar() {
        this.owner = "";
        this.appointments = null;
    }

    public UserCalendar(String owner, List<Appointment> appointments) {
        this.owner = owner;
        this.appointments = appointments;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
