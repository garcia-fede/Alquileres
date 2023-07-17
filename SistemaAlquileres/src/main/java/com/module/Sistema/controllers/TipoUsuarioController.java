/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author Federico
 */
@Controller
public class TipoUsuarioController {

    @RequestMapping("/Cliente")
    public String redirectUsuario(){
        return ("Cliente");
    }
    
    @RequestMapping("/Empleado")
    public String redirectEmpleado(){
        return ("Empleado");
    }
    
    @RequestMapping("/Admin")
    public String redirectAdmin(){
        return ("Admin");
    }    
}