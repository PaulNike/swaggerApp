package com.semana7.swagger.service;

import com.semana7.swagger.entity.CategoriaEntity;
import com.semana7.swagger.entity.EditorEntity;

import java.util.List;

public interface EditorService {

    List<EditorEntity> obtenerTodos();
    EditorEntity obtenerPorId(Long id) throws Exception;
    EditorEntity crear(EditorEntity editor);
    EditorEntity actualizar(Long id, EditorEntity editor) throws Exception;
    String eliminar(Long id) throws Exception;
}
