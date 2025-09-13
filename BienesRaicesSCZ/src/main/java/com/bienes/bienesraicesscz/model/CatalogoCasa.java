package com.bienes.bienesraicesscz.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "catalogo_casas")
public class CatalogoCasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String direccion;

    @Column(length = 1000)
    private String imagenUrl; // <-- CAMPO NUEVO

    @Column(nullable = false)
    private int habitaciones;

    @Column(nullable = false)
    private int banos;

    @Column(name = "superficie_m2", nullable = false)
    private double superficie;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    @Column(length = 2000)
    private String descripcion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getImagenUrl() { return imagenUrl; } // <-- NUEVO GETTER/SETTER
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
    public int getHabitaciones() { return habitaciones; }
    public void setHabitaciones(int habitaciones) { this.habitaciones = habitaciones; }
    public int getBanos() { return banos; }
    public void setBanos(int banos) { this.banos = banos; }
    public double getSuperficie() { return superficie; }
    public void setSuperficie(double superficie) { this.superficie = superficie; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}