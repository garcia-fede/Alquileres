/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Alquiler;
import com.module.Sistema.repositories.Ialquiler;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */
@Service
public class AlquileresServiceImplement implements AlquileresService{
    @Autowired
        private Ialquiler ialquiler;

    @Override
    public List<Alquiler> findAll() {
        return ialquiler.findAll();
    }

    //Metodo creado no implementado por Springboot
    @Override
    public List<Alquiler> findAllCustom() {
        return ialquiler.findAllCustom();
    }

    @Override
    public Optional<Alquiler> findById(long id) {
        return ialquiler.findById(id);
    }

    @Override
    public Alquiler add(Alquiler a) {
        Optional<Alquiler> objalquiler = ialquiler.findById(a.getId());
        if(!objalquiler.isEmpty()){
            a.setFecha_inicio(objalquiler.get().getFecha_inicio());
            a.setFecha_fin(objalquiler.get().getFecha_fin());
            a.setFecha_firma(objalquiler.get().getFecha_firma());
        }
        return ialquiler.save(a);
    }

    @Override
    public Alquiler update(Alquiler a) {
        Alquiler objalquiler;
        objalquiler = ialquiler.getById(a.getId());
        BeanUtils.copyProperties(a, objalquiler);
        return ialquiler.save(objalquiler);
    }

    @Override
    public Alquiler delete(Alquiler a) {
        Alquiler objalquiler =ialquiler.getById(a.getId());   
        objalquiler.setEstado(false);
        return ialquiler.save(objalquiler);
    }
    
}
