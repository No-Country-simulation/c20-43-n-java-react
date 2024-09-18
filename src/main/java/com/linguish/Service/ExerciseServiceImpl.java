package com.linguish.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.Exercise;
import com.linguish.Interface.IExercisesService;
import com.linguish.Repository.ExercisesRepository;
import com.linguish.Repository.ModuleRepository;
import com.linguish.Entity.Module;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements IExercisesService {

    private final ModuleRepository moduleRepository;
    private final ExercisesRepository exercisesRepository;

    @Override
    public List<Exercise> getExercises() {
        return exercisesRepository.findAll();
    }
    
    @Override
    public Exercise getExercisesById(Long id) {
        return exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
    }
    
    @Override
    public String saveExercises(Exercise exercises) throws IOException {
        // Module foundModule = moduleRepository.findById(exercises.getModule().getModuleId()).orElseThrow(() -> new EntityNotFoundException());
        // exercises.setModule(foundModule);
        Exercise newExercise = exercisesRepository.save(exercises);
        if (newExercise == null) {
            throw new IllegalStateException("No se encuentra el ejercicio en la BD");
        }
        return "Se guardó correctamente el ejercicio";
    }
    
    @Override
    public void updateExercisesById(Long id, Exercise exercises) throws IOException {
        Exercise exerciseUpdated = exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
        // exerciseUpdated.setExerciseName(null);
        exerciseUpdated.setText(null);
        // exerciseUpdated.setKeys(null);
        exerciseUpdated.setLevel(id);
        // exerciseUpdated.setExerciseType(null);
        exerciseUpdated.setCompleted(null);
        exerciseUpdated.setCompletedDate(null);
        Exercise exercise = exercisesRepository.save(exerciseUpdated);
        if (exercise == null) {
            throw new IllegalStateException("Ocurrio un error en la actualización");
        }
    }

    @Override
    public void deleteExercisesById(Long id) throws IOException {
        Exercise exercise = exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
        exercisesRepository.delete(exercise);
    }
}