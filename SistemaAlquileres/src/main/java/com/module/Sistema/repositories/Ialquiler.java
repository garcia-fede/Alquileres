/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.module.Sistema.repositories;

import com.module.Sistema.entities.Alquiler;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Federico
 */

public interface Ialquiler extends JpaRepository<Alquiler, Long>{
    @Query("select a from alquileres a where a.estado = '1'")
    List<Alquiler> findAllCustom();
}