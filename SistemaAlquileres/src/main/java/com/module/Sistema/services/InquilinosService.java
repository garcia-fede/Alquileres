/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.services;

import com.module.Sistema.entities.Inquilino;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Federico
 */
public interface InquilinosService {
    public List<Inquilino> findAll();
    
    public List<Inquilino> findAllCustom();

    //Optional evalua que el metodo quiza retorna vacio
    public Optional<Inquilino> findById(long id);

    public Inquilino add(Inquilino i);

    public Inquilino update(Inquilino i);

    public Inquilino delete(Inquilino i);
}
