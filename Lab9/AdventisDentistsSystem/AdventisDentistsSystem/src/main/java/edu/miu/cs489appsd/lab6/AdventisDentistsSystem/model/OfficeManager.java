package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OfficeManagers")
public class OfficeManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officemanagerId;

    private String firstname;
    private String lastname;

    private String phone;

    private String email;

    @OneToOne(mappedBy = "officeManager")
    private Appointment appointment;
}
