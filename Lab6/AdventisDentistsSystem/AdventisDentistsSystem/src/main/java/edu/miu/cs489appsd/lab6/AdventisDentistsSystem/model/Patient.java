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
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    private String pno;
    private String firstname;
    private String lastname;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true, nullable = true)
    private Address patientAddress;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;

    public Patient(Integer patientId,String pno,String fname, String lname, String phone, LocalDate dob) {
        this.patientId =patientId;
        this.pno = pno;
        this.firstname = fname;
        this.lastname = lname;
        this.phone = phone;
        this.dob = dob;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("patientId=").append(patientId);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", dob='").append(dob).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
