
package com.occe.controller;

import com.occe.model.Departamento;
import com.occe.service.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoService departamentoService;
    
    @Operation(summary = "Obtiene un listado general con informacion de cada uno de los departamentos",description = "Obtiene un areglo de listas con información de cada uno de los departamentos de la universidad.")
    @GetMapping("/departamentos")
    private ResponseEntity<List<Departamento>> getAllDepartamentos(){
        return ResponseEntity.ok(departamentoService.findAll());
    }
    
}
