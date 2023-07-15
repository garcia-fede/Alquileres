package com.module.Sistema.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Federico
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
//Autocomplete setters y getters
@Data
//Establecer la clase como una entidad JPA para relacionar con la base de datos
@Entity(name="inquilinos")
//Referir la tabla de la base de datos a relacionar
@Table(name="inquilinos")

public class Inquilino implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @Column(name="id_inquilino")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="NIF")
    private int NIF;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="fecha_nacimiento")
    private Date fecha_nacimiento;
    @Column(name="telefono")
    private int telefono;
    @OneToOne
    @JoinColumn(name="id_usuario",nullable = false)
    private Usuario id_usuario;
    @Column(name="estado")
    private boolean estado;
    
    public void setEstado(boolean b) {
        estado = b;
    }
}
