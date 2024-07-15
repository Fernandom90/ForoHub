package com.alura.ForoHub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private static TopicoRepository topicoRepository;

    // Método para obtener todos los tópicos (debería ser no estático)
    public static List<Model> getAllTopicos() {
        return topicoRepository.findAll();
    }

    // Método para crear un nuevo tópico
    public void crearTopico(TopicoRequest request) {
        // Verificar si ya existe un tópico con el mismo título
        if (topicoRepository.existsByTitulo(request.getTitulo())) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título");
        }

        // Crear el tópico
        Model nuevoTopico = new Model();
        nuevoTopico.setTitulo(request.getTitulo());
        nuevoTopico.setMensaje(request.getMensaje());
        nuevoTopico.setAutor(request.getAutor());
        nuevoTopico.setCurso(request.getCurso());

        // Guardar en la base de datos
        topicoRepository.save(nuevoTopico);
    }
    // Método para actualizar un tópico existente
    public static void actualizarTopico(Long id, TopicoRequest request) {
        // Verificar si el tópico existe en la base de datos
        Optional<Model> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            // Si existe, obtener el tópico y actualizar sus datos
            Model topico = optionalTopico.get();
            topico.setTitulo(request.getTitulo());
            topico.setMensaje(request.getMensaje());
            topico.setAutor(request.getAutor());
            topico.setCurso(request.getCurso());

            // Guardar los cambios en la base de datos
            topicoRepository.save(topico);
        } else {
            throw new IllegalArgumentException("No se encontró un tópico con el ID proporcionado: " + id);
        }
    }

    // Método para eliminar un tópico por ID
    public static void eliminarTopico(Long id) {
        // Verificar si el tópico existe en la base de datos
        Optional<Model> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            // Si existe, eliminar el tópico de la base de datos
            topicoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró un tópico con el ID proporcionado: " + id);
        }
    }
}
