package com.linguish.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.Exercises;
import com.linguish.Interface.IExercisesService;
import com.linguish.Repository.ExercisesRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements IExercisesService {

    private final ExercisesRepository exercisesRepository;

    @Override
    public List<Exercises> getExercises() {
        return exercisesRepository.findAll();
    }
    
    @Override
    public Exercises getExercisesById(Long id) {
        return exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
    }
    
    @Override
    public String saveExercises(Exercises exercises) throws IOException {
        Exercises exercise = exercisesRepository.save(exercises);
        if (exercise == null) {
            throw new IllegalStateException("No se encuentra el ejercicio en la BD");
        }
        return "Se guardó correctamente el ejercicio";
    }
    
    @Override
    public void updateExercisesById(Long id, Exercises exercises) throws IOException {
        Exercises exercise = exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
        exercise.setExerciseName(null);
        exercise.setText(null);
        exercise.setKeys(null);
        exercise.setLevel(id);
        exercise.setExerciseType(null);
        exercise.setCompleted(null);
        exercise.setCompletedDate(null);

        

    }

    @Override
    public void deleteExercisesById(Long id) throws IOException {
        Exercises exercise = exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
        exercisesRepository.delete(exercise);
    }
}
