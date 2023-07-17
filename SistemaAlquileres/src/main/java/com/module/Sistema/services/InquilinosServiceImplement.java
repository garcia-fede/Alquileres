/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Inquilino;
import com.module.Sistema.repositories.Iinquilino;
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
public class InquilinosServiceImplement implements InquilinosService{
    @Autowired
        private Iinquilino iinquilino;

    @Override
    public List<Inquilino> findAll() {
        return iinquilino.findAll();
    }

    //Metodo creado no implementado por Springboot
    @Override
    public List<Inquilino> findAllCustom() {
        return iinquilino.findAllCustom();
    }

    @Override
    public Optional<Inquilino> findById(long id) {
        return iinquilino.findById(id);
    }

    @Override
    public Inquilino add(Inquilino i) {
        long idUnica = i.getId_usuario().getId();
        boolean isRepeated = false;
        List<Inquilino> listInquilinos = iinquilino.findAll();
        for (Inquilino inquilino : listInquilinos) {
            if (inquilino.getId_usuario().getId() == idUnica) {
                isRepeated = true;
            }
        }
        if(isRepeated){
            return null;
        } else{
            return iinquilino.save(i);
        }
    }

    @Override
    public Inquilino update(Inquilino i) {
        Inquilino objinquilino;
        objinquilino = iinquilino.getById(i.getId());
        BeanUtils.copyProperties(i, objinquilino);
        return iinquilino.save(objinquilino);
    }

    @Override
    public Inquilino delete(Inquilino i) {
        Inquilino objinquilino =iinquilino.getById(i.getId());   
        objinquilino.setEstado(false);
        return iinquilino.save(objinquilino);
    }
    
}
