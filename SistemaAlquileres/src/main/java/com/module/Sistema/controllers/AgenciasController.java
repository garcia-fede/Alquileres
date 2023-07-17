/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Agencia;
import com.module.Sistema.services.AgenciasService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Presentacion
 */
@Controller
public class AgenciasController {
    @Autowired
    //Servicio conectado al controlador
    private AgenciasService service;
    
    //En singular y mayuscula "Agencia" para diferenciar del rest controller
    @RequestMapping("/Agencias/Gestion")
    public String viewAgencias(Model model){
        List<Agencia> listAgencias = service.findAll();
        model.addAttribute("listAgencias",listAgencias);
        return("AgenciasGestion");
    }
    
    @RequestMapping("/Agencias/Vigentes")
    public String viewAgenciasVigentes(Model model){
        List<Agencia> listAgenciasCustom = service.findAllCustom();
        model.addAttribute("listAgenciasCustom",listAgenciasCustom);
        return("AgenciasVigentes");
    }
    
    @RequestMapping("/Agencias/New")
    public String showNewAgenciaForm(Model model){
        Agencia agencia = new Agencia();
        model.addAttribute("agencia",agencia);
        return ("New_Agencia");
    }
    
    @RequestMapping(value="/Agencias/save", method = RequestMethod.POST)
     public String saveAgencia(@ModelAttribute("Agencia") Agencia agencia){
        service.add(agencia);
        return("redirect:/Agencias/Gestion");
    }
    
    @RequestMapping("/Agencias/edit/{id}")
    public ModelAndView showEditAgenciaForm(@PathVariable(name="id") Agencia a){
        ModelAndView mav = new ModelAndView("Edit_Agencia");
        Agencia agencia = service.update(a);
        mav.addObject("agencia",agencia);
        return mav;
    }
    
    @RequestMapping("/Agencias/delete/{id}")
    public String deleteAgencia(@PathVariable(name="id") Agencia a){
        service.delete(a);
        return ("redirect:/Agencias/Gestion");
    }
    
}
