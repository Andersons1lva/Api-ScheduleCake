package com.example.scheduleCake.repositories;

import com.example.scheduleCake.models.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EncomendaRepository extends JpaRepository<Encomenda, UUID> {
}
