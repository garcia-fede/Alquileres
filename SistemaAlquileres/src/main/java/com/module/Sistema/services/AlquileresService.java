/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Alquiler;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Federico
 */
public interface AlquileresService {
    public List<Alquiler> findAll();
    
    public List<Alquiler> findAllCustom();

    //Optional evalua que el metodo quiza retorna vacio
    public Optional<Alquiler> findById(long id);

    public Alquiler add(Alquiler a);

    public Alquiler update(Alquiler a);

    public Alquiler delete(Alquiler a);
}
