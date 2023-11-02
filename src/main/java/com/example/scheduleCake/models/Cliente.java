package com.example.scheduleCake.models;

import com.example.scheduleCake.request.ClienteRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "cliente")
@Entity(name = "cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String telefone;
    private String endereco;

    public Cliente(ClienteRequestDTO data){
        this.nome = data.nome();
        this.telefone = data.telefone();
        this.endereco = data.telefone();
    }

}
