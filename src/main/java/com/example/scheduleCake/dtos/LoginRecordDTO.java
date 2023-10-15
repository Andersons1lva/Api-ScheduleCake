package com.example.scheduleCake.dtos;

import com.example.scheduleCake.models.Login;

public record LoginRecordDTO(Long id, String email, String senha, String salt) {
    public LoginRecordDTO(Login login){
        this(login.getId(), login.getEmail(), login.getSenha(), login.getSalt());
    }
}
