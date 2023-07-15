/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Vivienda;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Federico
 */
public interface ViviendasService {
    public List<Vivienda> findAll();
    
    public List<Vivienda> findAllCustom();

    //Optional evalua que el metodo quiza retorna vacio
    public Optional<Vivienda> findById(long id);

    public Vivienda add(Vivienda v);

    public Vivienda update(Vivienda v);

    public Vivienda delete(Vivienda v);
}
