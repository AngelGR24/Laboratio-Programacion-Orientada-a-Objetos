package com.catalogo.videojuegos.service;

import com.catalogo.videojuegos.model.Videojuego;
import com.catalogo.videojuegos.repository.VideojuegoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    private final VideojuegoRepository repositorio;

    public VideojuegoServiceImpl(VideojuegoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Videojuego> obtenerTodos() {
        return repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Videojuego> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    @Transactional
    public Videojuego guardar(Videojuego videojuego) {
        return repositorio.save(videojuego);
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        repositorio.deleteById(id);
    }
}