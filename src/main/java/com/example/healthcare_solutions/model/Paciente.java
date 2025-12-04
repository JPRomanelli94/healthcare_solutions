package com.example.healthcare_solutions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Paciente {

    private Long id_paciente;
    private String nombre_paciente;
    private String apellido_paciente;
    private String dni;

}
