package com.linguish.Controller;


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

import com.linguish.Entity.Exercise;
import com.linguish.Interface.IExercisesService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

import java.util.*;

@RestController
@RequestMapping("/exercise")
@AllArgsConstructor
public class ExerciseController {

    private final IExercisesService exercisesService;

    @Operation(summary = "Obtener todos los ejercicios", description = "Este endpoint devuelve una lista de todos los ejercicios registrados.")
    @GetMapping("/find/all")
    public ResponseEntity<List<Exercise>> findAllExercises(){
        return new ResponseEntity<>(exercisesService.getRegisters(), HttpStatus.OK);
    }
    
    @Operation(summary = "Obtener un ejercicio por su ID", description = "Este endpoint obtiene la información de un ejercicio basado en su ID.")
    @GetMapping("/find/{id}")
    public ResponseEntity<Exercise> findExercise(@PathVariable Long id){
        return new ResponseEntity<>(exercisesService.getRegisterById(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo ejercicio", description = "Este endpoint permite crear un nuevo ejercicio dentro de un módulo.")   
    @PostMapping("/save")
    public ResponseEntity<Exercise> saveExercise(@RequestBody Exercise exercise){
        return new ResponseEntity<>(exercisesService.saveRegister(exercise), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un ejercicio por su ID", description = "Este endpoint permite actualizar la información de un ejercicio existente proporcionando su ID.")
    @PutMapping("/update/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise exerciseUpdated){
        return new ResponseEntity<>(exercisesService.updateRegisterById(id, exerciseUpdated), HttpStatus.OK);
    }
    
    @Operation(summary = "Eliminar un ejercicio por su ID", description = "Este endpoint elimina un ejercicio basado en su ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id){
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
