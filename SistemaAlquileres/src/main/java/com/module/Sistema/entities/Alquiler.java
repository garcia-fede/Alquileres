package com.module.Sistema.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
@Entity(name="alquileres")
//Referir la tabla de la base de datos a relacionar
@Table(name="alquileres")

public class Alquiler implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @Column(name="id_alquiler")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fecha_inicio")
    private Date fecha_inicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fecha_fin")
    private Date fecha_fin;
    @Column(name="importe_mensual")
    private int importe_mensual;
    @Column(name="fianza")
    private int fianza;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fecha_firma")
    private Date fecha_firma;
    @ManyToOne
    @JoinColumn(name="id_inquilino")
    private Inquilino id_inquilino;
    @ManyToOne
    @JoinColumn(name="id_vivienda")
    private Vivienda id_vivienda;
    @Column(name="id_alquiler_anterior", nullable = true)
    private Vivienda id_alquiler_anterior;
    @Column(name="estado")
    private boolean estado;
    
    public void setEstado(boolean b) {
        estado = b;
    }
}
