package com.catalogo.videojuegos.repository;

import com.catalogo.videojuegos.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    List<Videojuego> findByPlataformaIgnoreCase(String plataforma);
}