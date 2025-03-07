package com.linguish.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.Progress;
import com.linguish.Entity.User;
import com.linguish.Interface.IProgressService;
import com.linguish.Repository.ModuleRepository;
import com.linguish.Repository.ProgressRepository;
import com.linguish.Repository.UserRepository;
import com.linguish.Entity.Module;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgressServiceImpl implements IProgressService {

    private final ProgressRepository progressRepository;
    private final ModuleRepository moduleRepository;
    private final UserRepository userRepository;

    @Override
    public List<Progress> getRegisters() {
        return progressRepository.findAll();
    }
    
    @Override
    public Progress getRegisterById(Long id) {
        return progressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));
    }

    @Override
    public Progress saveRegister(Progress newRegister) {
        Module module = moduleRepository.findById(newRegister.getModuleId()).orElseThrow(() -> new EntityNotFoundException());
        User user = userRepository.findById(newRegister.getModuleId()).orElseThrow(() -> new EntityNotFoundException());
        // module.getProgress().add(newRegister);
        // user.getProgressList().add(newRegister);
        newRegister.setModule(module);
        newRegister.setUser(user);
        return progressRepository.save(newRegister);
    }

    @Override
    public Progress updateRegisterById(Long id, Progress updatedRegister) {
        Progress updatedProgress = progressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));
        updatedProgress.setPercentageCompleted(updatedRegister.getPercentageCompleted());
        updatedProgress.setIsCompleted(updatedRegister.getIsCompleted());        
        return progressRepository.save(updatedProgress);
    }
    
    @Override
    public void deleteRegisterById(Long id) {
        Progress deletedProgress = progressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontró el progreso"));
        progressRepository.delete(deletedProgress);
    }

}
