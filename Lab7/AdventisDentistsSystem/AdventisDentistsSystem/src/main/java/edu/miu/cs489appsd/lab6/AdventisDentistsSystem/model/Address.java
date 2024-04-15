package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String location;
    @Column(length = 16)
    private String zipCode;

    @OneToOne(mappedBy = "patientAddress")
    private Patient patient;

    @OneToOne(mappedBy = "surgeryAddress")
    private Surgery surgery;

    public Address(Integer addressId,String location, String zipCode) {
        this.addressId =addressId;
        this.location =location;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("addressId=").append(addressId);
        sb.append(", location='").append(location).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
