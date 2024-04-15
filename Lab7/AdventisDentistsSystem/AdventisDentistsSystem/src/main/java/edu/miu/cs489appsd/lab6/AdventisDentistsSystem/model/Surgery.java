package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;

    private String sno;
    private String name;
    private String phone;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "address", unique = true, nullable = true)
    private Address surgeryAddress;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointmentList;

    public Surgery(Integer surgeryId,String sno,String name, String phone, Address address) {
        this.surgeryId = surgeryId;
        this.sno = sno;
        this.name = name;
        this.phone = phone;
        this.surgeryAddress = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Surgery{");
        sb.append("surgeryId=").append(surgeryId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
