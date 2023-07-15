/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Alquiler;
import com.module.Sistema.services.AlquileresService;
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
public class AlquileresController {
    @Autowired
    //Servicio conectado al controlador
    private AlquileresService service;
    
    //En singular y mayuscula "Alquiler" para diferenciar del rest controller
    @RequestMapping("/Alquiler")
    public String viewHomepage(Model model){
        List<Alquiler> listAlquileres = service.findAll();
        model.addAttribute("listAlquileres",listAlquileres);
        return("Alquiler");
    }
    
    @RequestMapping("/Alquiler/findAllCustom")
    public String viewHomePageCustom(Model model){
        List<Alquiler> listAlquileresCustom = service.findAllCustom();
        model.addAttribute("listAlquileresCustom",listAlquileresCustom);
        return("Alquiler");
    }
    
    @RequestMapping("/Alquiler/new")
    public String showNewAlquilerForm(Model model){
        Alquiler alquiler = new Alquiler();
        model.addAttribute("alquiler",alquiler);
        return ("New_Alquiler");
    }
    
    @RequestMapping(value="/Alquiler/save", method = RequestMethod.POST)
     public String saveAlquiler(@ModelAttribute("Alquiler") Alquiler alquiler){
        service.add(alquiler);
        return("redirect:/Alquiler");
    }
    
    @RequestMapping("/Alquiler/edit/{id}")
    public ModelAndView showEditAlquilerForm(@PathVariable(name="id") Alquiler u){
        ModelAndView mav = new ModelAndView("Edit_Alquiler");
        Alquiler alquiler = service.update(u);
        mav.addObject("alquiler",alquiler);
        return mav;
    }
    
    @RequestMapping("/Alquiler/delete/{id}")
    public String deleteAlquiler(@PathVariable(name="id") Alquiler u){
        service.delete(u);
        return ("redirect:/Alquiler");
    }
    
}
