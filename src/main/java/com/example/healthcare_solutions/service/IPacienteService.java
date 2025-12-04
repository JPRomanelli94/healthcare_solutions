package com.example.healthcare_solutions.service;

import com.example.healthcare_solutions.model.Paciente;

import java.util.List;

public interface IPacienteService {

    List<Paciente> findAll();

    Paciente findById(Long id);

    void save(Paciente paciente);
}
