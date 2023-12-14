package com.semana7.swagger.service.impl;

import com.semana7.swagger.dao.EditorDAO;
import com.semana7.swagger.entity.CategoriaEntity;
import com.semana7.swagger.entity.EditorEntity;
import com.semana7.swagger.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorServiceImpl implements EditorService {

    @Autowired
    private EditorDAO editorDAO;

    @Override
    public List<EditorEntity> obtenerTodos() {
        return editorDAO.findAll();
    }

    @Override
    public EditorEntity obtenerPorId(Long id) throws Exception {
        Optional<EditorEntity> editor = editorDAO.findById(id);
        if(editor.isPresent()){
            return editor.get();
        }else{
            throw new Exception("Error No existe el Editor: "+ id);
        }
    }

    @Override
    public EditorEntity crear(EditorEntity editor) {
        return editorDAO.save(editor);
    }

    @Override
    public EditorEntity actualizar(Long id, EditorEntity editor) throws Exception {
        Optional<EditorEntity> editorEncontrado = editorDAO.findById(id);
        if(editorEncontrado.isPresent()){
            EditorEntity editorUpdate = editorEncontrado.get();
            editorUpdate.setNombre(editor.getNombre());
            editorUpdate.setEstado(editor.getEstado());
            return editorDAO.save(editorUpdate);
        }else{
            throw new Exception("No se logro actualizar, Editor no existe "+ id);
        }
    }

    @Override
    public String eliminar(Long id) throws Exception {
        Optional<EditorEntity> editorEncontrado = editorDAO.findById(id);
        return editorEncontrado.map(editor -> {
            editor.setEstado(0);
            editorDAO.save(editor);
            return "Eliminado";
        }).orElse(null);
    }
}
