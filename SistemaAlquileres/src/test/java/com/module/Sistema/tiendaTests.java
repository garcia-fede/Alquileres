package com.module.Sistema;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Presentacion
 */
@ContextConfiguration
public class tiendaTests {
    @Test
    public void generatepassword(){
        BCryptPasswordEncoder passGen = new BCryptPasswordEncoder();
        System.out.println(passGen.encode("prueba"));
    }
}
