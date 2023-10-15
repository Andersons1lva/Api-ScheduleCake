package com.example.scheduleCake.repositories;

import com.example.scheduleCake.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepository extends JpaRepository<Login, UUID> {

}
