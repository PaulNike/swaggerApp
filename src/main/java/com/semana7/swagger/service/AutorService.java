package com.semana7.swagger.service;

import com.semana7.swagger.entity.AutorEntity;

import java.util.List;

public interface AutorService {
    List<AutorEntity> obtenerTodos();
    AutorEntity obterAutorPorId(Long id) throws Exception;
    AutorEntity crear(AutorEntity autor);
    AutorEntity actualizar(Long id, AutorEntity autor) throws Exception;
    String eliminar(Long id) throws Exception;

}
