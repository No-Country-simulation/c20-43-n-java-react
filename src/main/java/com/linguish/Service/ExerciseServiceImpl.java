package com.linguish.Service;

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
    public List<Exercise> getRegisters() {
        return exercisesRepository.findAll();
    }
    
    @Override
    public Exercise getRegisterById(Long id) {
        return exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }
    
    
    @Override
    public Exercise saveRegister(Exercise newRegister) {
        Module module = moduleRepository.findById(newRegister.getModuleId()).orElseThrow(() -> new EntityNotFoundException());
        newRegister.setModule(module);
        return exercisesRepository.save(newRegister);
    }

    @Override
    public Exercise updateRegisterById(Long id, Exercise updatedRegister) {

        Exercise exerciseUpdated = exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
        
        exerciseUpdated.setText(updatedRegister.getText());
        exerciseUpdated.setAnswers(updatedRegister.getAnswers());
        exerciseUpdated.setCompleted(updatedRegister.getCompleted());

        //borra los registros del tipo de ejercicio
        exerciseUpdated.getExerciseType().clear();
        exerciseUpdated.setExerciseType(updatedRegister.getExerciseType());
        return exercisesRepository.save(exerciseUpdated);
    }
    
    @Override
    public void deleteRegisterById(Long id) {
        Exercise exercise = exercisesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el ejercicio en la BD"));
        exercisesRepository.delete(exercise);
    }
}
