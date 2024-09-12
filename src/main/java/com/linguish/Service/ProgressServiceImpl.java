package com.linguish.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.Progress;
import com.linguish.Interface.IProgressService;
import com.linguish.Repository.ProgressRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgressServiceImpl implements IProgressService {

    private final ProgressRepository progressRepository;
    
    @Override
    public List<Progress> getProgress() {
        return progressRepository.findAll();
    }
    
    @Override
    public Progress getProgressById(Long id) {
        return progressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));
    }
    
    @Override
    public String saveProgress(Progress progress) throws IOException {
        Progress newProgress = progressRepository.save(progress);
        if (newProgress == null) {
            throw new IllegalStateException("Error al guardar el progreso en la BD");
        }
        return "Se guardó correctamente";
    }
    
    @Override
    public void updateProgressById(Long id, Progress progress) throws IOException {
        Progress updatedProgress = progressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));

        updatedProgress.setUser(progress.getUser());
        // updatedProgress.setModule(progress.getModule());
        updatedProgress.setPercentageCompleted(progress.getPercentageCompleted());
        updatedProgress.setIsCompleted(progress.getIsCompleted());
        updatedProgress.setLastUpdated(progress.getLastUpdated());
        // updatedProgress.setExercises(Progress);
        Progress ProgressUpdated = progressRepository.save(updatedProgress);
        if (ProgressUpdated == null) {
            throw new IllegalStateException("Error al actualizar la BD");
        }
    }
    
    @Override
    public void deleteProgressById(Long id) throws IOException {
        Progress deletedProgress = progressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el progreso"));
        progressRepository.delete(deletedProgress);
    }
}
