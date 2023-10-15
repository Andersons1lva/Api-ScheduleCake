package com.example.scheduleCake.dtos;

import com.example.scheduleCake.models.Login;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record LoginRecordDTO(UUID id, @NotNull String email, @NotNull String senha) {
    public LoginRecordDTO(Login login){
        this(login.getId(), login.getEmail(), login.getSenha());
    }
}
