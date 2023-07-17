/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.restcontrollers;

import com.module.Sistema.entities.Alquiler;
import com.module.Sistema.services.AlquileresService;
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
@RequestMapping("/alquileres")
public class AlquileresRestController {
    @Autowired
    private AlquileresService service;
    
    @GetMapping
    public List<Alquiler> findAll(){
        return service.findAll();
    }
    
    @GetMapping("/findAllCustom")
    public List<Alquiler> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Alquiler> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Alquiler add(@RequestBody Alquiler u){
        System.out.println(u);
       //return service.add(u); 
       return null;
    }
    @PutMapping("/{id}")
    public Alquiler update(@PathVariable Long id,@RequestBody Alquiler u){
        u.setId(id);
       return service.update(u); 
    }
    @DeleteMapping("/{id}")
    public Alquiler delete(@PathVariable Long id){
        Alquiler objalquiler =new Alquiler();
        objalquiler.setEstado(false);
       return service.delete(Alquiler.builder().id(id).build()); 
    }
    
}
