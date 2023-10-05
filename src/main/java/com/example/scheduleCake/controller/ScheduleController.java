package com.example.scheduleCake.controller;

import com.example.scheduleCake.schedule.Schedule;
import com.example.scheduleCake.schedule.ScheduleRepository;
import com.example.scheduleCake.schedule.ScheduleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository repository;
    @GetMapping
    public List<ScheduleResponseDTO> getAll(){
        List<ScheduleResponseDTO> scheduleList = repository.findAll().stream().map(ScheduleResponseDTO::new).toList();
        return scheduleList;
    }
}
