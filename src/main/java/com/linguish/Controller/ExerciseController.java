package com.linguish.Controller;


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

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/exercise")
@AllArgsConstructor
public class ExerciseController {

    private final IExercisesService exercisesService;

    @GetMapping("/find/all")
    public List<Exercise> findAllExercises(){
        
        return exercisesService.getExercises();
    }
    
    @GetMapping("/find/{id}")
    public Exercise findExercise(@PathVariable Long id){
        return exercisesService.getExercisesById(id);
    }

    @PostMapping("/save")
    public String saveExercise(@RequestBody Exercise exercises) throws IOException{
        return exercisesService.saveExercises(exercises);
    }

    @PutMapping("/update/{id}")
    public void updateExercise(@PathVariable Long id, @RequestBody Exercise exercises) throws IOException{
        exercisesService.updateExercisesById(id, exercises);

    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteExercise(@PathVariable Long id) throws IOException{
        exercisesService.deleteExercisesById(id);

    }
}
