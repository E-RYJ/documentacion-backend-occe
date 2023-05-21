
package com.occe.controller;

import com.occe.model.Programa;
import com.occe.service.ProgramaService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/programa")
public class ProgramaController {
    
    @Autowired
    private ProgramaService programaService;
    
    @Operation(summary = "Obtener lista global de programas academicos",description = "Obtiene el listado de todos los programas academicos.")
    @GetMapping("/programas")
    private ResponseEntity<List<Programa>> getAllProgramas(){
        return ResponseEntity.ok(programaService.findAll());
    }
    
    @Operation(summary = "Obtener descripcion un programa por: {clave}",description = "Retorna una lista con informacion de un departanto por: {clave}")
    @GetMapping("/{clave}")
    private Programa getDescripcionByClave(@PathVariable("clave") String clave){
        return programaService.getDescripcionByClave(clave);
    }
    
}
