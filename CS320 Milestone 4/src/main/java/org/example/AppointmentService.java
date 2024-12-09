package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Written By: Cody Adams
 * Manages a collection of appointments.
 */
public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>(); // Stores appointments by ID

    //Adds appointment to service if ID is unique.

    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

   //Deletes an appointment by its ID.

    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentId);
    }

    //Retrieves an appointment by its ID.

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}

