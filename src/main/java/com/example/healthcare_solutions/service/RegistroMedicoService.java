package com.example.healthcare_solutions.service;

import com.example.healthcare_solutions.model.RegistroMedico;
import com.example.healthcare_solutions.repository.RegistroMedicoRepositoryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroMedicoService implements IRegistroMedicoService{

    @Autowired
    private RegistroMedicoRepositoryRedis registroMedicoRepositoryRedis;

    @Override
    public List<RegistroMedico> findAll() {
        return registroMedicoRepositoryRedis.findAll();
    }

    @Override
    public RegistroMedico findById(Long id) {
        return registroMedicoRepositoryRedis.findById(id);
    }

    @Override
    public void save(RegistroMedico registroMedico) {
        registroMedicoRepositoryRedis.save(registroMedico);
    }
}
