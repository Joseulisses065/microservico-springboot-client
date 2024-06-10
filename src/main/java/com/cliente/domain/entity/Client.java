package com.cliente.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String cpf;
    private String  name;
    private String age;

    public Client(String cpf, String name, String age) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }
}
