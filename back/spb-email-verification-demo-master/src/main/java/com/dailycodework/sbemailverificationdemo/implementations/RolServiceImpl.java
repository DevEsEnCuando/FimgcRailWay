package com.dailycodework.sbemailverificationdemo.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.Rol;
import com.dailycodework.sbemailverificationdemo.repositories.IRolRepository;
import com.dailycodework.sbemailverificationdemo.services.IRolService;

@Service
public class RolServiceImpl implements IRolService {
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> list() {
        return rolRepository.findAll();
    }			


    @Override
    public Rol register(Rol entity) {
        return rolRepository.save(entity);
    }

    @Override
    public Rol update(Long id, Rol rol) {
        Rol rolExistente = rolRepository.findById(id).orElse(null);
        if (rolExistente != null) {
            rolExistente.setNombre(rol.getNombre());
            return rolRepository.save(rolExistente);
        }
        return null;
    }

    @Override
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
    @Override
    public Rol findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }
}
