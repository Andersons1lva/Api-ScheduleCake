package com.example.scheduleCake.controller;

import com.example.scheduleCake.dtos.LoginRecordDTO;
import com.example.scheduleCake.models.Login;
import com.example.scheduleCake.repositories.LoginRepository;
import com.example.scheduleCake.request.LoginRequestDTO;
import com.example.scheduleCake.response.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("schedule/login")
public class LoginController {
    @Autowired
    private LoginRepository repository;

    @PostMapping
    public TokenResponse login(@RequestBody LoginRequestDTO data) {
        String email = data.getEmail();
        String senha = data.getSenha();

        Login login = repository.findByEmail(email);
        if(login == null) {
            return new TokenResponse(null,"Usuário não encontrado");
        }
        if (!login.getSenha().equals(senha)){
            return new TokenResponse(null, "Senha incorreta");
        }

        String token = Jwts.builder()
                .setSubject(login.getId().toString())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, "my-secret-key")
                .compact();

        return new TokenResponse(token, "Login realizado com sucesso");
    }

    @GetMapping
    public List<LoginRecordDTO> getAll(){
        List<LoginRecordDTO> scheduleList = repository.findAll().stream().map(LoginRecordDTO::new).toList();
        return scheduleList;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLogin(@PathVariable(value = "id") UUID id){
        Optional<Login> login = repository.findById(id);
        if (login.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login not found");
        }
        repository.delete(login.get());
        return ResponseEntity.status(HttpStatus.OK).body("Login deleted sucessfully");
    }


}
