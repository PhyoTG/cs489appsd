package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository  extends JpaRepository<Appointment, Integer> {
//    @Query(value = "select * from Appointments")
//    public List<Appointment> getAppointmentList();

}
