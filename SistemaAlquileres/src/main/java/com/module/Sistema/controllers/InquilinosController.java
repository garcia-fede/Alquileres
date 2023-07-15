/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Inquilino;
import com.module.Sistema.services.InquilinosService;
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
public class InquilinosController {
    @Autowired
    //Servicio conectado al controlador
    private InquilinosService service;
    
    //En singular y mayuscula "Inquilino" para diferenciar del rest controller
    @RequestMapping("/Inquilino")
    public String viewHomepage(Model model){
        List<Inquilino> listInquilinos = service.findAll();
        model.addAttribute("listInquilinos",listInquilinos);
        return("Inquilino");
    }
    
    @RequestMapping("/Inquilino/findAllCustom")
    public String viewHomePageCustom(Model model){
        List<Inquilino> listInquilinosCustom = service.findAllCustom();
        model.addAttribute("listInquilinosCustom",listInquilinosCustom);
        return("Inquilino");
    }
    
    @RequestMapping("/Inquilino/new")
    public String showNewInquilinoForm(Model model){
        Inquilino inquilino = new Inquilino();
        model.addAttribute("inquilino",inquilino);
        return ("New_Inquilino");
    }
    
    @RequestMapping(value="/Inquilino/save", method = RequestMethod.POST)
     public String saveInquilino(@ModelAttribute("Inquilino") Inquilino inquilino){
        service.add(inquilino);
        return("redirect:/Inquilino");
    }
    
    @RequestMapping("/Inquilino/edit/{id}")
    public ModelAndView showEditInquilinoForm(@PathVariable(name="id") Inquilino i){
        ModelAndView mav = new ModelAndView("Edit_Inquilino");
        Inquilino inquilino = service.update(i);
        mav.addObject("inquilino",inquilino);
        return mav;
    }
    
    @RequestMapping("/Inquilino/delete/{id}")
    public String deleteInquilino(@PathVariable(name="id") Inquilino i){
        service.delete(i);
        return ("redirect:/Inquilino");
    }
    
}
