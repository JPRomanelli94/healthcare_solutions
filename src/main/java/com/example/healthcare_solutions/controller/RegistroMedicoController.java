package com.example.healthcare_solutions.controller;

import com.example.healthcare_solutions.model.Paciente;
import com.example.healthcare_solutions.model.RegistroMedico;
import com.example.healthcare_solutions.service.IPacienteService;
import com.example.healthcare_solutions.service.IRegistroMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroMedicoController {

    @Autowired
    private IRegistroMedicoService registroMedicoService;

    @GetMapping
    public List<RegistroMedico> findAll(){
        return registroMedicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroMedico> findById(@PathVariable Long id){
        RegistroMedico registroMedico = registroMedicoService.findById(id);
        return ResponseEntity.ok(registroMedico);
    }

    @PostMapping
    public ResponseEntity<String> createRegistroMedico(@RequestBody RegistroMedico registroMedico){
        registroMedicoService.save(registroMedico);
        return ResponseEntity.ok("Registro creado exitosamente");
    }

}
