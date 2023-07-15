/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.module.Sistema.repositories;

import com.module.Sistema.entities.Inquilino;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Federico
 */

public interface Iinquilino extends JpaRepository<Inquilino, Long>{
    @Query("select i from inquilinos i where i.estado = '1'")
    List<Inquilino> findAllCustom();
}