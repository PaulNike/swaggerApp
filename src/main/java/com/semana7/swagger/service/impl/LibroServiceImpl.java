package com.semana7.swagger.service.impl;

import com.semana7.swagger.dao.LibroDAO;
import com.semana7.swagger.entity.LibroEntity;
import com.semana7.swagger.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroDAO libroDAO;
    @Override
    public List<LibroEntity> obtenerTodos() {
        return libroDAO.findAll();
    }

    @Override
    public LibroEntity obtenerPorId(Long id) throws Exception {
        Optional<LibroEntity> libroEncontrado = libroDAO.findById(id);
        if(libroEncontrado.isPresent()){
            return libroEncontrado.get();
        }else{
            throw new Exception("Error: No encontre el Libro: " + id);
        }
    }

    @Override
    public LibroEntity crear(LibroEntity libro) {
        return libroDAO.save(libro);
    }

    @Override
    public LibroEntity actualizar(Long id, LibroEntity libro) throws Exception {
        Optional<LibroEntity> libroEncontrado = libroDAO.findById(id);
        if(libroEncontrado.isPresent()){
            LibroEntity libroUpdate = libroEncontrado.get();
            libroUpdate.setTitulo(libro.getTitulo());
            libroUpdate.setEstado(libro.getEstado());
            libroUpdate.setEditor(libro.getEditor());
            libroUpdate.setAutores(libro.getAutores());
            libroUpdate.setCategorias(libro.getCategorias());
            return libroDAO.save(libroUpdate);
        }else{
            throw new Exception("Error: No se actualizo  el Libro: " + id);
        }
    }

    @Override
    public String eliminar(Long id) throws Exception {
        Optional<LibroEntity> libroOptional = libroDAO.findById(id);
        return libroOptional.map(editor -> {
            editor.setEstado(0); // Cambiado a 0 para indicar que no está eliminado
            return "Eliminado! ";
        }).orElse(null);
    }
}
