package com.semana7.swagger.controller;

import com.semana7.swagger.entity.AutorEntity;
import com.semana7.swagger.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping()
    public List<AutorEntity> listandoTodos(){
        return  autorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorEntity> obtenerUno(@PathVariable Long id) throws Exception {
        AutorEntity autor = autorService.obterAutorPorId(id);
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<AutorEntity> crear(@RequestBody AutorEntity autor){
        AutorEntity autorGuardado = autorService.crear(autor);
        return new ResponseEntity<>(autorGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorEntity> actualizar(@PathVariable Long id, @RequestBody AutorEntity autor) throws Exception {
        AutorEntity autorActualizado = autorService.actualizar(id,autor);
        if(autor != null){
            return ResponseEntity.ok(autorActualizado);
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws Exception {
        String autorEliminado = autorService.eliminar(id);
        if(autorEliminado != null){
            return ResponseEntity.ok("Eliminado!");
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
