package com.example.healthcare_solutions.repository;

import com.example.healthcare_solutions.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PacienteRepositoryRedis {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "PACIENTES"; // la "tabla" en redis

    @Autowired
    public PacienteRepositoryRedis(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Crear / actualizar un paciente
    public void save(Paciente paciente) {
        redisTemplate.opsForHash().put(KEY, paciente.getId_paciente().toString(), paciente);
    }

    // Buscar uno
    public Optional<Paciente> findById(Long id) {
        return Optional.ofNullable((Paciente) redisTemplate.opsForHash().get(KEY, id.toString()));
    }

    // Buscar todos
    public List<Paciente> findAll() {
        return redisTemplate.opsForHash()
                .values(KEY)
                .stream()
                .map(obj -> (Paciente) obj)
                .collect(Collectors.toList());
    }

    // Borrar uno
    public void delete(Long id) {
        redisTemplate.opsForHash().delete(KEY, id.toString());
    }
}
