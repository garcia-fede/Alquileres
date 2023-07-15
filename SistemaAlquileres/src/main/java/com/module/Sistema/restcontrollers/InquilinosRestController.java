/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.module.Sistema.restcontrollers;

import com.module.Sistema.entities.Inquilino;
import com.module.Sistema.services.InquilinosService;
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
@RequestMapping("/inquilinos")
public class InquilinosRestController {
    
    public Inquilino checkNewDuplicate(List<Inquilino> existingInquilinos, boolean isDuplicate, Inquilino newInquilino){
        for (Inquilino existingInquilino : existingInquilinos) {
            System.out.println(existingInquilino);
            System.out.println(newInquilino);
            System.out.println(existingInquilino.getId_usuario()==newInquilino.getId_usuario());
            if (existingInquilino.getNIF()==newInquilino.getNIF()
                || existingInquilino.getId()==newInquilino.getId()
                || existingInquilino.getId_usuario()==newInquilino.getId_usuario()
                    ) {
                isDuplicate=true;
                break;
            }
            else{
                isDuplicate=false;
            }
        }
        if(isDuplicate){
            return null;
        } else{
            return newInquilino; 
        }
    }
    
    public Inquilino checkUpdateDuplicate(List<Inquilino> existingInquilinos, boolean isDuplicate, Inquilino newInquilino){
        for (Inquilino existingInquilino : existingInquilinos) {
            if (existingInquilino.getNIF()==newInquilino.getNIF()
                || existingInquilino.getId_usuario()==newInquilino.getId_usuario()
                    ) {
                isDuplicate=true;
                break;
            }
            else{
                isDuplicate=false;
            }
        }
        if(isDuplicate){
            return null;
        } else{
            return newInquilino; 
        }
    }
    
    @Autowired
    private InquilinosService service;
    
    @GetMapping
    public List<Inquilino> findAll(){
        return service.findAll();
    }
    
    @GetMapping("/findAllCustom")
    public List<Inquilino> findAllCustom(){
        return service.findAllCustom();
    }
    
     @GetMapping("/{id}")
    public Optional<Inquilino> findById(@PathVariable Long id){
        return service.findById(id);
    }
    
    @PostMapping
    public Inquilino add(@RequestBody Inquilino i){
        List<Inquilino> existingInquilinos = service.findAll();
        Boolean isDuplicate=false;

        return service.add(checkNewDuplicate(existingInquilinos,isDuplicate,i)); 
    }
    @PutMapping("/{id}")
    public Inquilino update(@PathVariable Long id,@RequestBody Inquilino i){
        List<Inquilino> existingInquilinos = service.findAll();
        Boolean isDuplicate=false;
        
        i.setId(id);
        return service.update(checkUpdateDuplicate(existingInquilinos,isDuplicate,i)); 
    }
    @DeleteMapping("/{id}")
    public Inquilino delete(@PathVariable Long id){
        Inquilino objinquilino =new Inquilino();
        objinquilino.setEstado(false);
       return service.delete(Inquilino.builder().id(id).build()); 
    }
    
}
