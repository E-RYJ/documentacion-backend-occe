
package com.occe.controller;

import com.occe.service.InscripcionService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/inscripcion")
public class InscripcionController {
    
    @Autowired
    private InscripcionService inscripcionService;
    
    @Operation(summary = "Listado de materias siendo cursadas por:{expediente}",description = "Retorna un arreglo con la clave de las materias estan siendo cursadas actualmente por un alumno segun su numero de expediente.")
    @GetMapping("/cursando/{expediente}")
    private List<Long> getMateriasCursando(@PathVariable("expediente") Long expediente){
        return inscripcionService.getMateriasCursando(expediente, "C");
    }
    
    @Operation(summary = "Listado de materias acreditas por:{expediente} ",description = "Retorna un arreglo con la clave de las materias acreditadas por un alumno segun su numero de expediente.")
    @GetMapping("/acreditadas/{expediente}")
    private List<Long> getMateriasAcreditadas(@PathVariable("expediente") Long expediente){
        return inscripcionService.getMateriasCursando(expediente, "A");
    }
    
    @Operation(summary = "Obtiene el semestre del alumno por:{expediente}",description = "Retorna el semestre en curso de un alumno por numero de expediente.")
    @GetMapping("/semestre/{expediente}")
    private Integer getSemestreCursando(@PathVariable("expediente") Integer expediente){
        return inscripcionService.getSemestreCursando(expediente);
    }
            
}
