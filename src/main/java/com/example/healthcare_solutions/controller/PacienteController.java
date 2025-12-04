package com.example.healthcare_solutions.controller;

import com.example.healthcare_solutions.model.Paciente;
import com.example.healthcare_solutions.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id){
        Paciente paciente = pacienteService.findById(id);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public ResponseEntity<String> createPaciente(@RequestBody Paciente paciente){
        pacienteService.save(paciente);
        return ResponseEntity.ok("Paciente creado exitosamente");
    }
}
