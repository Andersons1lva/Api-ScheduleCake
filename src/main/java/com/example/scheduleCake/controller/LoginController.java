package com.example.scheduleCake.controller;

import com.example.scheduleCake.dtos.LoginRecordDTO;
import com.example.scheduleCake.models.Login;
import com.example.scheduleCake.repositories.LoginRepository;
import com.example.scheduleCake.request.LoginRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("schedule/login")
public class LoginController {
    @Autowired
    private LoginRepository repository;

    @PostMapping
    public void salvaLogin(@RequestBody @Valid LoginRequestDTO data) {
        Login login = new Login(data);
        repository.save(login);
        return;
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
