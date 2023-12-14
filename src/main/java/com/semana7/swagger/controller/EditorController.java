package com.semana7.swagger.controller;

import com.semana7.swagger.entity.EditorEntity;
import com.semana7.swagger.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/editor")
public class EditorController {

    @Autowired
    private EditorService editorService;

    @GetMapping()
    public List<EditorEntity> listandoTodos(){
        return  editorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorEntity> obtenerUno(@PathVariable Long id) throws Exception {
        EditorEntity autor = editorService.obtenerPorId(id);
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<EditorEntity> crear(@RequestBody EditorEntity editor){
        EditorEntity editorGuardado = editorService.crear(editor);
        return new ResponseEntity<>(editorGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorEntity> actualizar(@PathVariable Long id, @RequestBody EditorEntity editor) throws Exception {
        EditorEntity editorActualizado = editorService.actualizar(id,editor);
        if(editorActualizado != null){
            return ResponseEntity.ok(editorActualizado);
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws Exception {
        String editorEliminado = editorService.eliminar(id);
        if(editorEliminado != null){
            return ResponseEntity.ok("Eliminado!");
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
