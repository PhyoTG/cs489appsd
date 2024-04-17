package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model;

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
@Table(name = "Dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;

    private String firstname;
    private String lastname;
    private String phone;
    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointmentList;

    public Dentist(Integer dentistId,String fname, String lname, String phone, String spec) {
        this.dentistId = dentistId;
        this.firstname = fname;
        this.lastname = lname;
        this.phone = phone;
        this.specialization = spec;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dentists{");
        sb.append("dentistId=").append(dentistId);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", specialization='").append(specialization).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
