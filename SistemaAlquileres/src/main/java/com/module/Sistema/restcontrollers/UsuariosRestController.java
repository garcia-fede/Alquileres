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
    
    public Usuario checkNewDuplicate(List<Usuario> existingUsuarios, boolean isDuplicate, Usuario newUsuario){
        for (Usuario existingUsuario : existingUsuarios) {
            if (existingUsuario.getDocumento()==newUsuario.getDocumento()
                || existingUsuario.getId()==newUsuario.getId()
                || existingUsuario.getCorreo().equals(newUsuario.getCorreo())
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
            return newUsuario; 
        }
    }
    
    public Usuario checkUpdateDuplicate(List<Usuario> existingUsuarios, boolean isDuplicate, Usuario newUsuario){
        for (Usuario existingUsuario : existingUsuarios) {
            if (existingUsuario.getDocumento()==newUsuario.getDocumento()
                || existingUsuario.getCorreo().equals(newUsuario.getCorreo())
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
            return newUsuario; 
        }
    }
    
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
        //Checkear que no se repitan valores únicos
        List<Usuario> existingUsuarios = service.findAll();
        Boolean isDuplicate=false;
        
        return service.add(checkNewDuplicate(existingUsuarios,isDuplicate,u));
    }
    
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id,@RequestBody Usuario u){
        List<Usuario> existingUsuarios = service.findAll();
        Boolean isDuplicate=false;
        
        u.setId(id);
        return service.update(checkUpdateDuplicate(existingUsuarios,isDuplicate,u)); 
    }
    @DeleteMapping("/{id}")
    public Usuario delete(@PathVariable Long id){
        Usuario objusuario =new Usuario();
        objusuario.setEstado(false);
        return service.delete(Usuario.builder().id(id).build()); 
    }
    
}
