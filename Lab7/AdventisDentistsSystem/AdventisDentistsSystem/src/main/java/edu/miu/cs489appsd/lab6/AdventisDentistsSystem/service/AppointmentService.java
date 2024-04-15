package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment addNewAppointment(Appointment newAppointment);

    Appointment getAppointmentId(Integer appointmentId);

    Appointment updateAppointment(Appointment editedAppointment);

    void deleteAppointmentById(Integer appointmentId);

}
