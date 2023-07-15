/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Vivienda;
import com.module.Sistema.repositories.Ivivienda;
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
public class ViviendasServiceImplement implements ViviendasService{
    @Autowired
        private Ivivienda ivivienda;

    @Override
    public List<Vivienda> findAll() {
        return ivivienda.findAll();
    }

    //Metodo creado no implementado por Springboot
    @Override
    public List<Vivienda> findAllCustom() {
        return ivivienda.findAllCustom();
    }

    @Override
    public Optional<Vivienda> findById(long id) {
        return ivivienda.findById(id);
    }

    @Override
    public Vivienda add(Vivienda v) {
        return ivivienda.save(v);
    }

    @Override
    public Vivienda update(Vivienda v) {
        Vivienda objvivienda;
        objvivienda = ivivienda.getById(v.getId());
        BeanUtils.copyProperties(v, objvivienda);
        return ivivienda.save(objvivienda);
    }

    @Override
    public Vivienda delete(Vivienda v) {
        Vivienda objvivienda =ivivienda.getById(v.getId());   
        objvivienda.setEstado(false);
        return ivivienda.save(objvivienda);
    }
    
}
