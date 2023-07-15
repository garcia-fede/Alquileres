/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.module.Sistema.repositories;

import com.module.Sistema.entities.Vivienda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Federico
 */

public interface Ivivienda extends JpaRepository<Vivienda, Long>{
    @Query("select v from viviendas v where v.estado = '1'")
    List<Vivienda> findAllCustom();
}