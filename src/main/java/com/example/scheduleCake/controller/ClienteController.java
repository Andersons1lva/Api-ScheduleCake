package com.example.scheduleCake.controller;

import com.example.scheduleCake.dtos.ClienteRecordDTO;
import com.example.scheduleCake.models.Cliente;
import com.example.scheduleCake.repositories.ClienteRepository;
import com.example.scheduleCake.request.ClienteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/schedule/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    @PostMapping
    public void criarCliente(@RequestBody ClienteRequestDTO data){
        Cliente cliente = new Cliente(data);
        repository.save(cliente);
        return;
    }
    @GetMapping
    public List<ClienteRecordDTO> getAll(){
        List<ClienteRecordDTO> listaCliente = repository.findAll().stream().map(ClienteRecordDTO::new).toList();
        return listaCliente;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable (value = "id") UUID id){
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found");
        }
        repository.delete(cliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Encomenda deleted sucessfully");
    }
}
