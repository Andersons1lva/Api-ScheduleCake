package com.example.scheduleCake.models;
/*
 * Está classe representa a tabela de login do Banco de Dados.
 * */

import com.example.scheduleCake.request.LoginRequestDTO;
import jakarta.persistence.*;
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
    private String email;
    private String senha;

    public Login(LoginRequestDTO data) {
        this.email = data.email();
        this.senha = data.senha();
    }

}
