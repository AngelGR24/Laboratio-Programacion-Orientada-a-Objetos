package com.catalogo.videojuegos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 2, max = 100, message = "El título debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "Debes indicar la plataforma")
    @Column(nullable = false, length = 50)
    private String plataforma;

    @NotBlank(message = "Debes indicar el género")
    @Column(nullable = false, length = 50)
    private String genero;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo")
    @Column(nullable = false)
    private Double precio;

    @NotNull(message = "Las horas jugadas son obligatorias")
    @Min(value = 0, message = "Las horas jugadas no pueden ser negativas")
    @Column(nullable = false)
    private Integer horasJugadas;

    public Videojuego() {
    }

    public Videojuego(String titulo, String plataforma, String genero, Double precio, Integer horasJugadas) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.precio = precio;
        this.horasJugadas = horasJugadas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getHorasJugadas() { return horasJugadas; }
    public void setHorasJugadas(Integer horasJugadas) { this.horasJugadas = horasJugadas; }
}