package com.module.Sistema.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name="usuarios")
//Referir la tabla de la base de datos a relacionar
@Table(name="usuarios")

public class Usuario implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @Column(name="id_usuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="documento")
    private int documento;
    @Column(name="tipo_documento")
    private String tipo_documento;
    @Column(name="nacionalidad")
    private String nacionalidad;
    @Column(name="user")
    private String user;
    @Column(name="password")
    private String password;
    @Column(name="rol")
    private String rol;
    @Column(name="correo")
    private String correo;
    @Column(name="telefono")
    private int telefono;
    @Column(name="fecha_alta")
    private Date fecha_alta;
    @Column(name="fecha_baja")
    private Date fecha_baja;
    @Column(name="estado")
    private boolean estado;

    public void setEstado(boolean b) {
        estado = b;
    }

}
