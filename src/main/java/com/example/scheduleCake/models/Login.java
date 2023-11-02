package com.example.scheduleCake.models;
/*
 * Está classe representa a tabela de login do Banco de Dados.
 * */

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "login")
@Entity(name = "login")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Login  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Email
    private String email;
    private String senha;

//    public Login(LoginRequestDTO data) {
//        this.email = data.email();
//        this.senha = data.senha();
//    }

}
