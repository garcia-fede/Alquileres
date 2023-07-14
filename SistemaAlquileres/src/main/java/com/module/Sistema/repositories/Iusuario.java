/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.module.Sistema.repositories;

import com.module.Sistema.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Federico
 */

public interface Iusuario extends JpaRepository<Usuario, Long>{
    @Query("select u from usuarios u where u.estado = '1'")
    List<Usuario> findAllCustom();
    
    Usuario findByUser(String user);
}