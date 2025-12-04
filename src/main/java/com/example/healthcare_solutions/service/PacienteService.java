package com.example.healthcare_solutions.service;

import com.example.healthcare_solutions.model.Paciente;
import com.example.healthcare_solutions.repository.PacienteRepositoryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private PacienteRepositoryRedis pacienteRepositoryRedis;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepositoryRedis.findAll();
    }

    @Override
    public Paciente findById(Long id) {
        return pacienteRepositoryRedis.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));

    }

    @Override
    public void save(Paciente paciente){
        pacienteRepositoryRedis.save(paciente);
    }
}
