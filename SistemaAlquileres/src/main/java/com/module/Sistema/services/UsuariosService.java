/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Federico
 */
public interface UsuariosService {
    public List<Usuario> findAll();
    
    public List<Usuario> findAllCustom();

    //Optional evalua que el metodo quiza retorna vacio
    public Optional<Usuario> findById(long id);

    public Usuario add(Usuario u);

    public Usuario update(Usuario u);

    public Usuario delete(Usuario u);
}
