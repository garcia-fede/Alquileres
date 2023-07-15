/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Agencia;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Federico
 */
public interface AgenciasService {
    public List<Agencia> findAll();
    
    public List<Agencia> findAllCustom();

    //Optional evalua que el metodo quiza retorna vacio
    public Optional<Agencia> findById(long id);

    public Agencia add(Agencia a);

    public Agencia update(Agencia a);

    public Agencia delete(Agencia a);
}
