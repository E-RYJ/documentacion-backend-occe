
package com.occe.controller;

import com.occe.model.Alumno;
import com.occe.model.info.AlumnoDepartamento;
import com.occe.model.info.AlumnoInfo;
import com.occe.model.info.PlanProgramaAlumno;
import com.occe.service.AlumnoService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
    
    @Autowired
    private AlumnoService alumnoService;
    
    @Operation(summary = "Obtiene informacion general del almuno por:{expediente}",description = "Retonorna una lista con informacion general acerca del alumno, como su departemento, campus, etc.")
    @GetMapping("/{expediente}")
    private Alumno getAlumnoByExpediente(@PathVariable("expediente") Long expediente){
        return alumnoService.findByExpediente(expediente);
    }
    
    @Operation(summary = "Obtiene informacion resumida del almuno por:{expediente}",description = "Retonorna una lista con informacion acerca del alumno, como su nombre campus, correo, etc.")
    @GetMapping("/datos-alumno/{expediente}")
    private AlumnoInfo getDatosAlumno(@PathVariable("expediente") Long expediente){
        return alumnoService.getInformacionAlumno(expediente);
    }
    
    @Operation(summary = "Obtiene el departamento de un almuno por:{expediente}",description = "Retorna una lista con la clave y nombre del departamento correspodiente a un alumno.")
    @GetMapping("/alumno-departamento/{expediente}")
    private AlumnoDepartamento getAlumnoDepartamento(@PathVariable("expediente") Long expediente){
        return alumnoService.getDepartamentoAlumno(expediente);
    }
    
    @Operation(summary = "Obtiene el plan y programa de un almuno por:{expediente}",description = "Retorna una lista con el plan y programa correspodiente a un alumno.")
    @GetMapping("/plan-programa/{expediente}")
    private PlanProgramaAlumno getPlanProgramaAlumno(@PathVariable("expediente") Integer expediente){
        return alumnoService.getPlanPrograma(expediente);
    }
    
}
