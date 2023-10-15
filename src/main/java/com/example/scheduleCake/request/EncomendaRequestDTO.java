package com.example.scheduleCake.request;

import java.util.Date;

public record EncomendaRequestDTO(String numero_da_encomenda, Long cliente_id, String bolo, String  massa,
                                  String recheio, Date data, double valor, double sinal) {
}
