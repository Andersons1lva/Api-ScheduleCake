package com.example.scheduleCake.repositories;

import com.example.scheduleCake.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
