package com.example.scheduleCake.dtos;

import com.example.scheduleCake.models.Ecomenda;

import java.util.Date;

public record EncomendaRecordDTO(Long id, String numero_da_encomenda, Long cliente_id, String bolo, String  massa,
                                 String recheio, Date data, double valor, double sinal) {

    public EncomendaRecordDTO(Ecomenda encomenda) {
        this(encomenda.getId(), encomenda.getNumero_da_encomenda(), encomenda.getCliente_id(), encomenda.getBolo(),
                encomenda.getMassa(), encomenda.getRecheio(), encomenda.getData(), encomenda.getValor(), encomenda.getSinal());
    }
}
