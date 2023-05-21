
package com.occe.controller;

import com.occe.model.Materia;
import com.occe.model.info.CulturestInfo;
import com.occe.model.info.MateriasPendientes;
import com.occe.model.info.MaximoMinimoMaterias;
import com.occe.model.info.PlanProgramaAlumno;
import com.occe.model.info.Solicitud;
import com.occe.model.info.SolicitudRequest;
import com.occe.service.AlumnoService;
import com.occe.service.InscripcionService;
import com.occe.service.MateriaService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/materia")
public class MateriaController {
    
    @Autowired
    private MateriaService materiaService;
        
    @Autowired
    private InscripcionService inscripcionService;
    
    @Autowired
    private AlumnoService alumnoService;    
    
    @Operation(summary = "Obtiene un listado global de materias.")
    @GetMapping("/materias")
    private ResponseEntity<List<Materia>> getAllMaterias(){
        return ResponseEntity.ok(materiaService.findAll());
    }
    
    @Operation(summary = "Obtener informacion estadistica sobre las materias pendientes por :{expendiente}",description = "Obtiene una lista con el la cantidad de materieas pendientes de un alumno.")
    @GetMapping("/materias-pendientes/{expediente}")
    private List<MateriasPendientes> obtenerDatosEstadisticos(@PathVariable("expediente") Integer expediente){
        PlanProgramaAlumno planPrograma = alumnoService.getPlanPrograma(expediente);        
        Integer semestre = inscripcionService.getSemestreCursando(expediente);
        materiaService.eliminaTablaTemporal();
        materiaService.crearTablaTemporal(expediente, semestre + 1);
        return materiaService.getMateriasPendientes(planPrograma.getPlan(), planPrograma.getProg(), expediente);
    }
    
    @Operation(summary = "Crea tabla de solicitudes por :{expendiente}")
    @GetMapping("/crear-tabla-solicitudes/{programa}-{plan}")
    private void crearTablaSolicitudes(@PathVariable("programa") String programa, @PathVariable("plan") Long plan){
        String tableName = programa + "_" + plan;        
        materiaService.crearTablaSolicitudes(tableName);
    }
    
    @Operation(summary = "Valida si hay solicutudes de un alumno por:{expediente}",description="Retorna un booleano true si es que existen solicitudes registradas en la base de datos para un alumno por : {expediente}")
    @GetMapping("/hay-solicitudes/{expediente}")
    private boolean haySolicitudesAlumno(@PathVariable("expediente") Integer expediente){
        PlanProgramaAlumno planPrograma = alumnoService.getPlanPrograma(expediente);
        String tableName = planPrograma.getProg() + "_" + planPrograma.getPlan();
        return materiaService.existenSolicitudesAlumno(tableName, expediente);
    }
    
    @Operation(summary = "Elimina la solicitud de un alumno por :{expediente}",description = "Elimina solicitudes de un alumno por: {expediente}")
    @GetMapping("/elimina-solicitudes/{expediente}")
    private void eliminaSolicitudesAlumno(@PathVariable("expediente") Integer expediente){
        PlanProgramaAlumno planPrograma = alumnoService.getPlanPrograma(expediente);
        String tableName = planPrograma.getProg() + "_" + planPrograma.getPlan();
        materiaService.eliminaSolicitudes(tableName, expediente);
    }
    
    @Operation(summary = "Obtener la cantidad maxima y minima de materias de un alumno por :{expendiente}",description = "Obtiene una lista con el numero maximo y minimo de materias de materias que a cursado un alumno.")
    @GetMapping("/maximo-minimo-materias/{expediente}")
    private MaximoMinimoMaterias getMaximoMinimoMaterias(@PathVariable("expediente") Integer expediente){
        return materiaService.getMaximoMinimoMaterias(expediente);
    }        
    
    @Operation(summary = "Obtener estatus culturest de un alumno por :{expendiente}")
    @GetMapping("/estatus-culturest/{expediente}")
    private CulturestInfo getEstatusCultures(@PathVariable("expediente") Long expediente){
        return materiaService.getEstatusCultures(expediente);
    }
    
    @Operation(summary = "Registrar un solicitud en la base datos",description="Inserta un registro en la base de datos en la tabla correspondiente a su materia y plan.")
    @PostMapping("/solicitar")
    private void insertarSolicitud(@RequestBody SolicitudRequest request){
        PlanProgramaAlumno planPrograma = alumnoService.getPlanPrograma(request.getExpediente());
        String tableName = planPrograma.getProg() + "_" + planPrograma.getPlan();
        materiaService.crearTablaSolicitudes(tableName);
        materiaService.insertarSolicitud(request, tableName);                 
    }
    
    
    @Operation(summary = "Consultar solicitud por: {expediente}",description="Consulta informacion en la base de datos de las solicutudes registradas por un alumno por: {expendiente}")
    @GetMapping("/consultar-solicitudes/{expediente}")
    private List<Solicitud> getSolicitudesAlumno(@PathVariable("expediente") Integer expediente){
        PlanProgramaAlumno planPrograma = alumnoService.getPlanPrograma(expediente);
        String tableName = planPrograma.getProg() + "_" + planPrograma.getPlan();        
        materiaService.crearTablaSolicitudes(tableName);
        Integer periodo = materiaService.getPeriodoAlumno(expediente);
        return materiaService.getSolicitudesAlumno(tableName, expediente, periodo);
    }
}
