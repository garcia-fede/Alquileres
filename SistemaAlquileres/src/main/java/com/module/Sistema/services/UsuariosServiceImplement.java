/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Usuario;
import com.module.Sistema.repositories.Iusuario;
import java.util.Date;
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
public class UsuariosServiceImplement implements UsuariosService{
    @Autowired
        private Iusuario iusuario;

    @Override
    public List<Usuario> findAll() {
        return iusuario.findAll();
    }

    //Metodo creado no implementado por Springboot
    @Override
    public List<Usuario> findAllCustom() {
        return iusuario.findAllCustom();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return iusuario.findById(id);
    }

    @Override
    public Usuario add(Usuario u) {
        Optional<Usuario> objusuario = iusuario.findById(u.getId());
        if(!objusuario.isEmpty()){
            u.setFecha_baja(objusuario.get().getFecha_baja());
        } else{
            u.setFecha_alta(new Date());
        }
        return iusuario.save(u);
    }

    @Override
    public Usuario update(Usuario u) {
        Usuario objusuario;
        objusuario = iusuario.getById(u.getId());
        BeanUtils.copyProperties(u, objusuario);
        return iusuario.save(objusuario);
    }

    @Override
    public Usuario delete(Usuario u) {
        Usuario objusuario =iusuario.getById(u.getId());   
        objusuario.setEstado(false);
        return iusuario.save(objusuario);
    }
    
}
