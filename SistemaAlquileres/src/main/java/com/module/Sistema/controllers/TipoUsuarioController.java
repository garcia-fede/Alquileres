/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Agencia;
import com.module.Sistema.services.AgenciasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


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
