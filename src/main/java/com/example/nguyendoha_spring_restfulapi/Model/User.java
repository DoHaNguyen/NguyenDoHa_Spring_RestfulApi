package com.example.nguyendoha_spring_restfulapi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// Nguyen Do ha 28/5/2022
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false, unique = true, length = 40)
    private String email;
    @Column(nullable = false, length = 22)
    private String password;
}
