package com.semana7.swagger.service.impl;

import com.semana7.swagger.dao.AutorDAO;
import com.semana7.swagger.entity.AutorEntity;
import com.semana7.swagger.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorDAO autorDAO;
    @Override
    public List<AutorEntity> obtenerTodos() {
        return autorDAO.findAll();
    }

    @Override
    public AutorEntity obterAutorPorId(Long id) throws Exception {
        Optional<AutorEntity> autor = autorDAO.findById(id);
        if(autor.isPresent()){
            return autor.get();
        }else{
            throw new Exception("Error No existe el Autor: "+ id);
        }
    }

    @Override
    public AutorEntity crear(AutorEntity autor) {
        return autorDAO.save(autor);
    }

    @Override
    public AutorEntity actualizar(Long id, AutorEntity autor) throws Exception {
        Optional<AutorEntity> autorEncontrado = autorDAO.findById(id);
        if(autorEncontrado.isPresent()){
            AutorEntity autorUpdate = autorEncontrado.get();
            autorUpdate.setNombre(autor.getNombre());
            autorUpdate.setEstado(autor.getEstado());
            return autorDAO.save(autorUpdate);
        }else{
            throw new Exception("No se logro actualizar, Autor no existe "+ id);
        }

    }

    @Override
    public String eliminar(Long id) throws Exception {
        Optional<AutorEntity> autorEncontrado = autorDAO.findById(id);
        return autorEncontrado.map(autor -> {
            autor.setEstado(0);
            autorDAO.save(autor);
            return "Eliminado";
        }).orElse(null);
        /*
        if(autorEncontrado.isPresent()){
            AutorEntity autorUpdate = autorEncontrado.get();
            autorUpdate.setEstado(0);
            autorDAO.save(autorUpdate);
            return "Eliminado";
        }else{
            throw new Exception("No se logro actualizar, Autor no existe "+ id);
        }*/
    }
}
