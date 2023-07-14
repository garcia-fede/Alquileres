/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.controllers;

import com.module.Sistema.entities.Usuario;
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
public class UsuariosController {
    @Autowired
    //Servicio conectado al controlador
    private UsuariosService service;
    
    //En singular y mayuscula "Usuario" para diferenciar del rest controller
    @RequestMapping("/Usuario")
    public String viewHomepage(Model model){
        List<Usuario> listUsuarios = service.findAll();
        model.addAttribute("listUsuarios",listUsuarios);
        return("Usuario");
    }
    
    @RequestMapping("/Usuario/findAllCustom")
    public String viewHomePageCustom(Model model){
        List<Usuario> listUsuariosCustom = service.findAllCustom();
        model.addAttribute("listUsuariosCustom",listUsuariosCustom);
        return("Usuario");
    }
    
    @RequestMapping("/Usuario/new")
    public String showNewUsuarioForm(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario",usuario);
        return ("New_Usuario");
    }
    
    @RequestMapping(value="/Usuario/save", method = RequestMethod.POST)
     public String saveUsuario(@ModelAttribute("Usuario") Usuario usuario){
        service.add(usuario);
        return("redirect:/Usuario");
    }
    
    @RequestMapping("/Usuario/edit/{id}")
    public ModelAndView showEditUsuarioForm(@PathVariable(name="id") Usuario u){
        ModelAndView mav = new ModelAndView("Edit_Usuario");
        Usuario usuario = service.update(u);
        mav.addObject("usuario",usuario);
        return mav;
    }
    
    @RequestMapping("/Usuario/delete/{id}")
    public String deleteUsuario(@PathVariable(name="id") Usuario u){
        service.delete(u);
        return ("redirect:/Usuario");
    }
    
}
