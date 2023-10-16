package com.example.scheduleCake.dtos;

import com.example.scheduleCake.models.Cliente;

import java.util.UUID;

public record ClienteRecordDTO(UUID id, String nome, String telefone, String endereco) {
    public ClienteRecordDTO(Cliente cliente){
        this(cliente.getId(),cliente.getNome(),cliente.getTelefone(), cliente.getEndereco());
    }
}
