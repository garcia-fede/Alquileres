/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Agencia;
import com.module.Sistema.repositories.Iagencia;
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
public class AgenciasServiceImplement implements AgenciasService{
    @Autowired
        private Iagencia iagencia;

    @Override
    public List<Agencia> findAll() {
        return iagencia.findAll();
    }

    //Metodo creado no implementado por Springboot
    @Override
    public List<Agencia> findAllCustom() {
        return iagencia.findAllCustom();
    }

    @Override
    public Optional<Agencia> findById(long id) {
        return iagencia.findById(id);
    }

    @Override
    public Agencia add(Agencia a) {
        return iagencia.save(a);
    }

    @Override
    public Agencia update(Agencia a) {
        Agencia objagencia;
        objagencia = iagencia.getById(a.getId());
        BeanUtils.copyProperties(a, objagencia);
        return iagencia.save(objagencia);
    }

    @Override
    public Agencia delete(Agencia a) {
        Agencia objagencia =iagencia.getById(a.getId());   
        objagencia.setEstado(false);
        return iagencia.save(objagencia);
    }
    
}
