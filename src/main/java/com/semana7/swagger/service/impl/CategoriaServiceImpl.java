package com.semana7.swagger.service.impl;

import com.semana7.swagger.dao.CategoriaDAO;
import com.semana7.swagger.entity.AutorEntity;
import com.semana7.swagger.entity.CategoriaEntity;
import com.semana7.swagger.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public List<CategoriaEntity> obtenerTodos() {
        return categoriaDAO.findAll();
    }

    @Override
    public CategoriaEntity obtenerPorId(Long id) throws Exception {
        Optional<CategoriaEntity> categoria = categoriaDAO.findById(id);
        if(categoria.isPresent()){
            return categoria.get();
        }else{
            throw new Exception("Error No existe la Categoria: "+ id);
        }
    }

    @Override
    public CategoriaEntity crear(CategoriaEntity categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public CategoriaEntity actualizar(Long id, CategoriaEntity categoria) throws Exception {
        Optional<CategoriaEntity> cateEncontrada = categoriaDAO.findById(id);
        if(cateEncontrada.isPresent()){
            CategoriaEntity catUpdate = cateEncontrada.get();
            catUpdate.setNombre(categoria.getNombre());
            catUpdate.setEstado(categoria.getEstado());
            return categoriaDAO.save(catUpdate);
        }else{
            throw new Exception("No se logro actualizar, Categoria no existe "+ id);
        }
    }

    @Override
    public String eliminar(Long id) throws Exception {
        Optional<CategoriaEntity> catEncontrado = categoriaDAO.findById(id);
        return catEncontrado.map(categoria -> {
            categoria.setEstado(0);
            categoriaDAO.save(categoria);
            return "Eliminado";
        }).orElse(null);
    }
}
