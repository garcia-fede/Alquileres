/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.restcontrollers;

import com.module.Sistema.entities.Usuario;
import com.module.Sistema.services.UsuariosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Federico
 */

@RestController
@RequestMapping("/usuarios")
public class UsuariosRestController {
    @Autowired
    private UsuariosService service;
    
    @GetMapping
    public List<Usuario> findAll(){
        return service.findAll();
    }
    
    @GetMapping("/findAllCustom")
    public List<Usuario> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Usuario add(@RequestBody Usuario u){
       return service.add(u); 
    }
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id,@RequestBody Usuario u){
        u.setId(id);
       return service.update(u); 
    }
    @DeleteMapping("/{id}")
    public Usuario delete(@PathVariable Long id){
        Usuario objusuario =new Usuario();
        objusuario.setEstado(false);
       return service.delete(Usuario.builder().id(id).build()); 
    }
    
}
