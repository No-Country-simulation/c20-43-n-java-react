package com.linguish.Repository;

import com.linguish.Entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisesRepository extends JpaRepository<Exercise, Long> {
}
