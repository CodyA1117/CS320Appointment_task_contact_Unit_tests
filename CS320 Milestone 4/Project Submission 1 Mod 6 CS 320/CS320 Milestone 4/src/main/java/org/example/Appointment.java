package org.example;

import java.util.Date;

/**
 * Written By: Cody Adams
 * Represents an appointment with an ID, date, and description.
 */
public class Appointment {
    private final String appointmentId; // Unique identifier for the appointment
    private final Date appointmentDate; // Date of the appointment
    private final String description; // Description of the appointment

    /**
     * Constructs an Appointment object with required fields.
     *
     * @param appointmentId   Unique ID (≤ 10 characters, not null).
     * @param appointmentDate Date of the appointment (not in the past, not null).
     * @param description     Description (≤ 50 characters, not null).
     */
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.appointmentId = appointmentId;
        this.appointmentDate = new Date(appointmentDate.getTime());
        this.description = description;
    }

    // Getter for appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Getter for appointment date (returns a copy to preserve immutability)
    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    // Getter for description
    public String getDescription() {
        return description;
    }
}

