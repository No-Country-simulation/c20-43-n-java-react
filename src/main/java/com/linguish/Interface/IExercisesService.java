package com.linguish.Interface;

import com.linguish.Entity.Exercises;

import java.io.IOException;
import java.util.List;

public interface IExercisesService {

    List<Exercises> getExercises();

    Exercises getExercisesById(Long id);

    String saveExercises(Exercises exercises) throws IOException;

    void updateExercisesById(Long id, Exercises exercises) throws IOException;

    void deleteExercisesById(Long id) throws IOException;
}
