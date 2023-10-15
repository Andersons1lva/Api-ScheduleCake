package com.example.scheduleCake.models;
/*
 * Está classe representa a tabela de encomenda do Banco de Dados.
 * */

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "encomenda")
@Entity(name = "encomenda")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ecomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero_da_encomenda;
    private Long cliente_id;
    private String bolo;
    private String  massa;
    private String recheio;
    private Date data;
    private double valor;
    private double sinal;

}
