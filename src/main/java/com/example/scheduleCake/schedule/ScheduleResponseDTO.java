package com.example.scheduleCake.schedule;

public record ScheduleResponseDTO(Long id,String nome_usuario, String senha) {
    public ScheduleResponseDTO(Schedule schedule){
        this(schedule.getId(),schedule.getNome_usuario(),schedule.getSenha());
    }
}
