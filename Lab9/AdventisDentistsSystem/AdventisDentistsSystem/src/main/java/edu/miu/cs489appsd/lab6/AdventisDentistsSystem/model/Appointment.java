package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.SurgeryService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String time;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "surgery", unique = false, nullable = true)
    private Surgery surgery;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient", unique = false, nullable = true)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist", unique = false, nullable = true)
    private Dentist dentist;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "officemanager", unique = false, nullable = true)
    private OfficeManager officeManager;

    public Appointment(Integer appointmentId,LocalDate date, String time, Surgery surgery,Patient patient, Dentist dentist) {
        this.appointmentId =appointmentId;
        this.date = date;
        this.time = time;
        this.surgery = surgery;
        this.patient =patient;
        this.dentist = dentist;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Appointment{");
        sb.append("appointmentId=").append(appointmentId);
        sb.append(", Date='").append(date).append('\'');
        sb.append(", Time='").append(time).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
