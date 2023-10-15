package com.example.scheduleCake.models;
/*
 * Está classe representa a tabela de encomenda do Banco de Dados.
 * */

import com.example.scheduleCake.request.EncomendaRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "encomenda")
@Entity(name = "encomenda")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Encomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String numero_da_encomenda;
    private Long cliente_id;
    private String bolo;
    private String  massa;
    private String recheio;
    private Date data;
    private double valor;
    private double sinal;

    public Encomenda(EncomendaRequestDTO data){
        this.numero_da_encomenda = data.numero_da_encomenda();
        this.cliente_id = data.cliente_id();
        this.bolo = data.bolo();
        this.massa = data.massa();
        this.recheio = data.recheio();
        this.data = data.data();
        this.valor = data.valor();
        this.sinal = data.sinal();
    }

}
