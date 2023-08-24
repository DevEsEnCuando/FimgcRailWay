package com.dailycodework.sbemailverificationdemo.services;

import java.util.List;

import com.dailycodework.sbemailverificationdemo.entities.Rol;

public interface IRolService {
    List<Rol> list();
    Rol register(Rol entity);
    Rol update(Long id, Rol rol);
    void deleteRol(Long id);
    Rol findByNombre(String nombre);
}
