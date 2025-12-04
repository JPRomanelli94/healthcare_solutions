package com.example.healthcare_solutions.repository;

import com.example.healthcare_solutions.model.RegistroMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RegistroMedicoRepositoryRedis {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "REGISTROS"; // la "tabla" en redis

    @Autowired
    public RegistroMedicoRepositoryRedis(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Crear / actualizar un registro
    public void save (RegistroMedico registro){
        redisTemplate.opsForHash().put(KEY,registro.getId_registro().toString(),registro);
    }

    // Buscar uno
    public RegistroMedico findById(Long id){
        return (RegistroMedico) redisTemplate.opsForHash().get(KEY, id.toString());
    }

    // Buscar todos
    public List<RegistroMedico> findAll() {
        return redisTemplate.opsForHash()
                .values(KEY)
                .stream()
                .map(obj -> (RegistroMedico) obj)
                .collect(Collectors.toList());
    }

    // Borrar uno
    public void delete(Long id) {
        redisTemplate.opsForHash().delete(KEY, id.toString());
    }
}
