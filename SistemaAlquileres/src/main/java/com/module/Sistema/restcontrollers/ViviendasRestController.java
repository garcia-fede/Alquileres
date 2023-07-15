/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.restcontrollers;

import com.module.Sistema.entities.Vivienda;
import com.module.Sistema.services.ViviendasService;
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
@RequestMapping("/viviendas")
public class ViviendasRestController {
    @Autowired
    private ViviendasService service;
    
    @GetMapping
    public List<Vivienda> findAll(){
        return service.findAll();
    }
    
    @GetMapping("/findAllCustom")
    public List<Vivienda> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Vivienda> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Vivienda add(@RequestBody Vivienda v){
       return service.add(v); 
    }
    @PutMapping("/{id}")
    public Vivienda update(@PathVariable Long id,@RequestBody Vivienda v){
        v.setId(id);
       return service.update(v); 
    }
    @DeleteMapping("/{id}")
    public Vivienda delete(@PathVariable Long id){
        Vivienda objvivienda =new Vivienda();
        objvivienda.setEstado(false);
       return service.delete(Vivienda.builder().id(id).build()); 
    }
    
}
