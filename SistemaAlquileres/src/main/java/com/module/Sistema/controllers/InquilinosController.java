/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Inquilino;
import com.module.Sistema.entities.Usuario;
import com.module.Sistema.services.InquilinosService;
import com.module.Sistema.services.UsuariosService;
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
    @Autowired
    private UsuariosService usuariosService;
    
    //En singular y mayuscula "Inquilino" para diferenciar del rest controller
    @RequestMapping("/Inquilinos/Gestion")
    public String viewHomepage(Model model){
        List<Inquilino> listInquilinos = service.findAll();
        model.addAttribute("listInquilinos",listInquilinos);
        return("InquilinosGestion");
    }
    
    @RequestMapping("/Inquilinos/findAllCustom")
    public String viewHomePageCustom(Model model){
        List<Inquilino> listInquilinosCustom = service.findAllCustom();
        model.addAttribute("listInquilinosCustom",listInquilinosCustom);
        return("InquilinosGestion");
    }
    
    @RequestMapping("/Inquilinos/New")
    public String showNewInquilinoForm(Model model){
        Inquilino inquilino = new Inquilino();
        List<Usuario> listUsuarios = usuariosService.findAllCustom();
        model.addAttribute("listUsuarios",listUsuarios);
        model.addAttribute("inquilino",inquilino);
        return ("New_Inquilino");
    }
    
    @RequestMapping(value="/Inquilinos/save", method = RequestMethod.POST)
     public String saveInquilino(@ModelAttribute("Inquilino") Inquilino inquilino){
        service.add(inquilino);
        return("redirect:/Inquilinos/Gestion");
    }
    
    @RequestMapping("/Inquilinos/edit/{id}")
    public ModelAndView showEditInquilinoForm(@PathVariable(name="id") Inquilino i){
        ModelAndView mav = new ModelAndView("Edit_Inquilino");
        List<Usuario> listUsuarios = usuariosService.findAllCustom();
        mav.addObject("listUsuarios",listUsuarios);
        Inquilino inquilino = service.update(i);
        mav.addObject("inquilino",inquilino);
        return mav;
    }
    
    @RequestMapping("/Inquilinos/delete/{id}")
    public String deleteInquilino(@PathVariable(name="id") Inquilino i){
        service.delete(i);
        return ("redirect:/Inquilino");
    }
    
}
