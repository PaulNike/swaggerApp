package com.semana7.swagger.service;

import com.semana7.swagger.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> obtenerTodos();
    CategoriaEntity obtenerPorId(Long id) throws Exception;
    CategoriaEntity crear(CategoriaEntity categoria);
    CategoriaEntity actualizar(Long id, CategoriaEntity categoria) throws Exception;
    String eliminar(Long id) throws Exception;
}
