
package com.occe.controller;

import com.occe.service.MatProgService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mat-prog")
public class MatProgController {
    
    @Autowired
    private MatProgService matProgService;
    
    @Operation(summary = "Obtener creditos de un alumno por :{plan}-{programa}-{expediente}",description = "Obtiene un areglo con los creditos de las materias de un alumno.")
    @GetMapping("/creditos-materia/{plan}-{programa}-{expediente}")
    private List<Long> getCreditosMateria(@PathVariable("plan") Long plan, @PathVariable("programa") String programa, @PathVariable("expediente") Long expediente){
        return matProgService.getCreditosMaterias(plan, programa, expediente);
    }
    
}
