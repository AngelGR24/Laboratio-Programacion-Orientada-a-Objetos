package com.catalogo.videojuegos.controller;

import com.catalogo.videojuegos.model.Videojuego;
import com.catalogo.videojuegos.service.VideojuegoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegoController {

    private final VideojuegoService servicio;

    public VideojuegoController(VideojuegoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("videojuegos", servicio.obtenerTodos());
        return "videojuegos/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        model.addAttribute("accion", "Registrar Videojuego");
        return "videojuegos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("videojuego") Videojuego videojuego,
                          BindingResult resultado,
                          Model model,
                          RedirectAttributes flash) {
        if (resultado.hasErrors()) {
            model.addAttribute("accion", videojuego.getId() == null ? "Registrar Videojuego" : "Editar Videojuego");
            return "videojuegos/formulario";
        }

        servicio.guardar(videojuego);
        flash.addFlashAttribute("mensajeExito", "¡Videojuego guardado correctamente!");
        return "redirect:/videojuegos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model, RedirectAttributes flash) {
        Optional<Videojuego> opcional = servicio.obtenerPorId(id);
        if (opcional.isEmpty()) {
            flash.addFlashAttribute("mensajeError", "El videojuego solicitado no existe.");
            return "redirect:/videojuegos";
        }
        model.addAttribute("videojuego", opcional.get());
        model.addAttribute("accion", "Editar Videojuego");
        return "videojuegos/formulario";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable("id") Long id, Model model, RedirectAttributes flash) {
        Optional<Videojuego> opcional = servicio.obtenerPorId(id);
        if (opcional.isEmpty()) {
            flash.addFlashAttribute("mensajeError", "El videojuego solicitado no existe.");
            return "redirect:/videojuegos";
        }
        model.addAttribute("videojuego", opcional.get());
        return "videojuegos/detalle";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
        try {
            servicio.eliminarPorId(id);
            flash.addFlashAttribute("mensajeExito", "Videojuego eliminado con éxito.");
        } catch (Exception e) {
            flash.addFlashAttribute("mensajeError", "No se pudo eliminar el registro.");
        }
        return "redirect:/videojuegos";
    }
}