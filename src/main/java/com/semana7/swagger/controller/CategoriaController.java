package com.semana7.swagger.controller;


import com.semana7.swagger.entity.CategoriaEntity;
import com.semana7.swagger.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public List<CategoriaEntity> listandoTodos(){
        return  categoriaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> obtenerUno(@PathVariable Long id) throws Exception {
        CategoriaEntity autor = categoriaService.obtenerPorId(id);
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<CategoriaEntity> crear(@RequestBody CategoriaEntity categoria){
        CategoriaEntity catGuardado = categoriaService.crear(categoria);
        return new ResponseEntity<>(catGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> actualizar(@PathVariable Long id, @RequestBody CategoriaEntity categoria) throws Exception {
        CategoriaEntity autorActualizado = categoriaService.actualizar(id,categoria);
        if(autorActualizado != null){
            return ResponseEntity.ok(autorActualizado);
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws Exception {
        String cateEliminado = categoriaService.eliminar(id);
        if(cateEliminado != null){
            return ResponseEntity.ok("Eliminado!");
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
