package com.example.healthcare_solutions.service;

import com.example.healthcare_solutions.model.RegistroMedico;

import java.util.List;

public interface IRegistroMedicoService {

    List<RegistroMedico> findAll();

    RegistroMedico findById(Long id);

    void save(RegistroMedico registroMedico);
}
