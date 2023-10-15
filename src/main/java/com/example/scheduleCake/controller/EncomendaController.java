package com.example.scheduleCake.controller;

import com.example.scheduleCake.models.Encomenda;
import com.example.scheduleCake.models.Login;
import com.example.scheduleCake.repositories.EncomendaRepository;
import com.example.scheduleCake.dtos.EncomendaRecordDTO;
import com.example.scheduleCake.request.EncomendaRequestDTO;
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
@RequestMapping("/schedule/encomenda")
public class EncomendaController {
    @Autowired
    private EncomendaRepository repository;

    @PostMapping
    public void saveEncomenda(@RequestBody EncomendaRequestDTO data){
        Encomenda encomenda = new Encomenda(data);
        repository.save(encomenda);
        return;
    }

    @GetMapping
    public List<EncomendaRecordDTO> getAll(){
        List<EncomendaRecordDTO> listaEncomenda = repository.findAll().stream().map(EncomendaRecordDTO::new).toList();
        return listaEncomenda;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEncomenda(@PathVariable(value = "id") UUID id){
        Optional<Encomenda> encomenda = repository.findById(id);
        if (encomenda.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encomenda not found");
        }
        repository.delete(encomenda.get());
        return ResponseEntity.status(HttpStatus.OK).body("Encomenda deleted sucessfully");
    }
}
