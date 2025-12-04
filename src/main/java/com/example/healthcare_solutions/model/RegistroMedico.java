package com.example.healthcare_solutions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RegistroMedico {

    private Long id_registro;
    private Long id_paciente;
    private String diagnostico;
    private String tratamiento;
    private String medicacion;

}
