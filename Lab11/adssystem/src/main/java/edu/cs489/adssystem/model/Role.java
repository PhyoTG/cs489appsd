package edu.cs489.adssystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String name;

    @OneToOne(mappedBy = "role")
    private User user;

    public Role(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }
}
