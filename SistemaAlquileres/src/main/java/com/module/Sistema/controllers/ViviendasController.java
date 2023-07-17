/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Vivienda;
import com.module.Sistema.services.ViviendasService;
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
public class ViviendasController {
    @Autowired
    //Servicio conectado al controlador
    private ViviendasService service;
    
    //En singular y mayuscula "Vivienda" para diferenciar del rest controller
    @RequestMapping("/Viviendas/Gestion")
    public String viewHomepage(Model model){
        List<Vivienda> listViviendas = service.findAll();
        model.addAttribute("listViviendas",listViviendas);
        return("ViviendasGestion");
    }
    
    @RequestMapping("/Viviendas/Disponibles")
    public String viewHomePageCustom(Model model){
        List<Vivienda> listViviendasCustom = service.findAllCustom();
        model.addAttribute("listViviendasCustom",listViviendasCustom);
        return("ViviendasDisponibles");
    }
    
    @RequestMapping("/Viviendas/new")
    public String showNewViviendaForm(Model model){
        Vivienda vivienda = new Vivienda();
        model.addAttribute("vivienda",vivienda);
        return ("New_Vivienda");
    }
    
    @RequestMapping(value="/Viviendas/save", method = RequestMethod.POST)
     public String saveVivienda(@ModelAttribute("Vivienda") Vivienda vivienda){
        service.add(vivienda);
        return("redirect:/Viviendas/Gestion");
    }
    
    @RequestMapping("/Viviendas/edit/{id}")
    public ModelAndView showEditViviendaForm(@PathVariable(name="id") Vivienda v){
        ModelAndView mav = new ModelAndView("Edit_Vivienda");
        Vivienda vivienda = service.update(v);
        mav.addObject("vivienda",vivienda);
        return mav;
    }
    
    @RequestMapping("/Viviendas/delete/{id}")
    public String deleteVivienda(@PathVariable(name="id") Vivienda v){
        service.delete(v);
        return ("redirect:/Viviendas/Gestion");
    }
    
}
