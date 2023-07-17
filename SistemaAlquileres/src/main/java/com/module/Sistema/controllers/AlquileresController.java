/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Alquiler;
import com.module.Sistema.entities.Inquilino;
import com.module.Sistema.entities.Vivienda;
import com.module.Sistema.services.AlquileresService;
import com.module.Sistema.services.InquilinosService;
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
public class AlquileresController {
    @Autowired
    //Servicio conectado al controlador
    private AlquileresService service;
    @Autowired
    private ViviendasService viviendasService;
    @Autowired
    private InquilinosService inquilinosService;
    
    //En singular y mayuscula "Alquiler" para diferenciar del rest controller
    @RequestMapping("/Alquileres/Gestion")
    public String viewGestionAlquileres(Model model){
        List<Alquiler> listAlquileres = service.findAll();
        model.addAttribute("listAlquileres",listAlquileres);
        return("AlquileresGestion");
    }
    
    @RequestMapping("/Alquileres/Habilitacion")
    public String viewHabilitacionAlquileres(Model model){
        List<Alquiler> listAlquileres = service.findAll();
        model.addAttribute("listAlquileres",listAlquileres);
        return("AlquileresHabilitacion");
    }
    
    @RequestMapping("/Alquileres/Vigentes")
    public String viewAlquileresVigentes(Model model){
        List<Alquiler> listAlquileres = service.findAll();
        model.addAttribute("listAlquileres",listAlquileres);
        return("AlquileresVigentes");
    }
    
    @RequestMapping("/Alquileres/New")
    public String showNewAlquilerForm(Model model){
        Alquiler alquiler = new Alquiler();
        List<Vivienda> listViviendas = viviendasService.findAllCustom();
        List<Inquilino> listInquilinos = inquilinosService.findAllCustom();
        model.addAttribute("listViviendas",listViviendas);
        model.addAttribute("listInquilinos",listInquilinos);
        model.addAttribute("alquiler",alquiler);
        return ("New_Alquiler");
    }
        
    @RequestMapping(value="/Alquileres/save", method = RequestMethod.POST)
     public String saveAlquiler(@ModelAttribute("Alquiler") Alquiler alquiler){
        try{
           service.add(alquiler);
           return("redirect:/Alquileres/Gestion");
        } catch(Exception e){
            return("ErrorPage");
        }
    }
     
    @RequestMapping("/Alquileres/Solicitud")
    public String showNewSolicitudForm(Model model){
        Alquiler alquiler = new Alquiler();
        List<Vivienda> listViviendas = viviendasService.findAllCustom();
        List<Inquilino> listInquilinos = inquilinosService.findAllCustom();
        model.addAttribute("listViviendas",listViviendas);
        model.addAttribute("listInquilinos",listInquilinos);
        model.addAttribute("alquiler",alquiler);
        return ("Solicitud_Alquiler");
    }
    
     @RequestMapping(value="/Alquileres/saveSolicitud", method = RequestMethod.POST)
     public String saveSolicitud(@ModelAttribute("Alquiler") Alquiler alquiler){
        try{
            alquiler.setEstado(false);
            service.add(alquiler);
            return("redirect:/Alquileres/Vigentes");
        } catch(Exception e){
            return("ErrorPage");
        }
    }
    
    @RequestMapping("/Alquileres/edit/{id}")
    public ModelAndView showEditAlquilerForm(@PathVariable(name="id") Alquiler a){
        ModelAndView mav = new ModelAndView("Edit_Alquiler");
        List<Vivienda> listViviendas = viviendasService.findAllCustom();
        List<Inquilino> listInquilinos = inquilinosService.findAllCustom();
        mav.addObject("listViviendas",listViviendas);
        mav.addObject("listInquilinos",listInquilinos);
        Alquiler alquiler = service.update(a);
        mav.addObject("alquiler",alquiler);
        return mav;
    }
    
    @RequestMapping("/Alquileres/delete/{id}")
    public String deleteAlquiler(@PathVariable(name="id") Alquiler a){
        service.delete(a);
        return ("redirect:/Alquileres/Habilitacion");
    }
    
    @RequestMapping("/Alquileres/authorize/{id}")
    public String authorizeAlquiler(@PathVariable(name="id") Alquiler a){
        a.setEstado(true);
        service.update(a);
        return ("redirect:/Alquileres/Habilitacion");
    }
    
}
