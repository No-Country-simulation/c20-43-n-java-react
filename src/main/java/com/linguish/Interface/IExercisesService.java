package com.linguish.Interface;

import com.linguish.Entity.Exercise;

import java.io.IOException;
import java.util.List;

public interface IExercisesService {

    List<Exercise> getExercises();

    Exercise getExercisesById(Long id);

    String saveExercises(Exercise exercises) throws IOException;

    void updateExercisesById(Long id, Exercise exercises) throws IOException;

    void deleteExercisesById(Long id) throws IOException;
}
