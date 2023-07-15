/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.restcontrollers;

import com.module.Sistema.entities.Agencia;
import com.module.Sistema.services.AgenciasService;
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
@RequestMapping("/agencias")
public class AgenciasRestController {
    @Autowired
    private AgenciasService service;
    
    @GetMapping
    public List<Agencia> findAll(){
        return service.findAll();
    }
    
    @GetMapping("/findAllCustom")
    public List<Agencia> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Agencia> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Agencia add(@RequestBody Agencia u){
       return service.add(u); 
    }
    @PutMapping("/{id}")
    public Agencia update(@PathVariable Long id,@RequestBody Agencia u){
        u.setId(id);
       return service.update(u); 
    }
    @DeleteMapping("/{id}")
    public Agencia delete(@PathVariable Long id){
        Agencia objagencia =new Agencia();
        objagencia.setEstado(false);
       return service.delete(Agencia.builder().id(id).build()); 
    }
    
}
