package com.linguish.Controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linguish.Entity.Progress;
import com.linguish.Interface.IProgressService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/progress")
@AllArgsConstructor
public class ProgressController {

    private final IProgressService progressService;

    @Operation(summary = "Obtener todos los progresos", description = "Este endpoint devuelve una lista de todos los progresos registrados.")
    @GetMapping("/find/all")
    public ResponseEntity<List<Progress>> findAllProgress(){
        return new ResponseEntity<>(progressService.getRegisters(), HttpStatus.OK);
    }
    
    @Operation(summary = "Obtener un progreso por su ID", description = "Este endpoint obtiene el progreso de un usuario basado en el ID del progreso.")
    @GetMapping("/find/{id}")
    public ResponseEntity<Progress> findProgress(@PathVariable Long id){
        return new ResponseEntity<>(progressService.getRegisterById(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo progreso", description = "Este endpoint permite crear un nuevo progreso para un usuario en un módulo.") 
    @PostMapping("/save")
    public ResponseEntity<Progress> saveProgress(@RequestBody Progress progress){
       return new ResponseEntity<>(progressService.saveRegister(progress), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un progreso por su ID", description = "Este endpoint permite actualizar la información de un progreso existente proporcionando su ID.")
    @PutMapping("/update/{id}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long id, @RequestBody Progress progress){
        return new ResponseEntity<>(progressService.updateRegisterById(id, progress), HttpStatus.OK);
    }
    
    @Operation(summary = "Eliminar un progreso por su ID", description = "Este endpoint elimina un progreso basado en su ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable Long id){
        progressService.deleteRegisterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
