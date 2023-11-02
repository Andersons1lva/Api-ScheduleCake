package com.example.scheduleCake.request;

import java.util.Date;
import java.util.UUID;

public record EncomendaRequestDTO(String numero_da_encomenda, UUID cliente_id, String bolo, String  massa,String recheio, Date data, double valor, double sinal) {
}
