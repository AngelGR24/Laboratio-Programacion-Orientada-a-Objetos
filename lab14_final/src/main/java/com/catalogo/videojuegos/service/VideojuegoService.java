package com.catalogo.videojuegos.service;

import com.catalogo.videojuegos.model.Videojuego;
import java.util.List;
import java.util.Optional;

public interface VideojuegoService {
    List<Videojuego> obtenerTodos();
    Optional<Videojuego> obtenerPorId(Long id);
    Videojuego guardar(Videojuego videojuego);
    void eliminarPorId(Long id);
}