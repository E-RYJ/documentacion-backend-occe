
package com.occe.controller;

import com.occe.model.info.CreditosInfo;
import com.occe.model.info.EstatusTipoAlumno;
import com.occe.model.info.NombreEstatusAlumno;
import com.occe.service.AlumnoAcadService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alumno-acad")
public class AlumnoAcadController {
    
    @Autowired
    private AlumnoAcadService alumnoAcadService;
    
    @Operation(summary = "Obtiene el ultimo periodo cursado por el alumno por :{expediente}",description = "Retorna un numero entero el cual es el ultimo periodo cursado por el alumno un alumno.")
    @GetMapping("/ultimo-periodo/{expediente}")
    private Long getUltimoPeriodoCursado(@PathVariable("expediente") Long expediente){
        return alumnoAcadService.getUltimoPeriodoCursado(expediente);
    }
    
    @Operation(summary = "Obtiene el estatus de un alumno por :{expediente}",description = "Retorna una lista con el estatus y tipo correspodiente a un alumno.")
    @GetMapping("/estatus-tipo/{expediente}")
    private EstatusTipoAlumno getEstatusAndTipoAlumno(@PathVariable("expediente") Long expediente){
        return alumnoAcadService.getEstatusAndTipoAlumno(expediente);
    }
    
    @Operation(summary = "Obtiene la cantidad aprobados de un alumno por :{expediente} asi como la cantidad de creditos necesarios para su programa",description = "Retorna un lista con la cantidad de creditos aprobados de un alumno por :{expediente} asi como la cantidad total de creditos del programa del alumno.")
    @GetMapping("/creditos/{expediente}")
    private CreditosInfo getCreditosNecesariosCreditosCursados(@PathVariable("expediente") Long expediente){
        return alumnoAcadService.getCreditosNecesariosCreditosCursados(expediente);
    }
    
    @Operation(summary = "Obtiene el estatus de un alumno del \"login\" por :{expediente}",description = "Retorna una lista con el nombre y status del \"login\" correspodiente a un alumno.")
    @GetMapping("/login/{expediente}")
    private NombreEstatusAlumno getNombreStatusAlumno(@PathVariable("expediente") Long expediente){
        return alumnoAcadService.getNombreStatusAlumno(expediente);
    }
    
}
