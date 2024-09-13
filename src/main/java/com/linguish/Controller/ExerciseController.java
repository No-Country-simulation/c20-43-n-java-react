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

import lombok.AllArgsConstructor;

import java.util.*;

@RestController
@RequestMapping("/exercise")
@AllArgsConstructor
public class ExerciseController {

    private final IExercisesService exercisesService;

    @GetMapping("/find/all")
    public ResponseEntity<List<Exercise>> findAllExercises(){
        return new ResponseEntity<>(exercisesService.getRegisters(), HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Exercise> findExercise(@PathVariable Long id){
        return new ResponseEntity<>(exercisesService.getRegisterById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Exercise> saveExercise(@RequestBody Exercise exercise){
        return new ResponseEntity<>(exercisesService.saveRegister(exercise), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise exerciseUpdated){
        return new ResponseEntity<>(exercisesService.updateRegisterById(id, exerciseUpdated), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id){
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
