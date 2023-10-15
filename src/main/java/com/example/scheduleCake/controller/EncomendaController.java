package com.example.scheduleCake.controller;

import com.example.scheduleCake.repositories.EncomendaRepository;
import com.example.scheduleCake.dtos.EncomendaRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule/encomenda")
public class EncomendaController {
    @Autowired
    private EncomendaRepository repository;

    @GetMapping
    public List<EncomendaRecordDTO> getAll(){
        List<EncomendaRecordDTO> encomendaList = repository.findAll().stream().map(EncomendaRecordDTO::new).toList();
        return encomendaList;
    }
}
