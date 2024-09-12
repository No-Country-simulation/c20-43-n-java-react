package com.linguish.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.Module;
import com.linguish.Entity.Enums.Level;
import com.linguish.Interface.IModuleService;
import com.linguish.Repository.ModuleRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ModuleServiceImpl implements IModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public List<Module> getModule() {
        return moduleRepository.findAll();
    }
    
    @Override
    public Module getModuleById(Long id) {
        return moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));
    }
    
    @Override
    public String saveModule(Module module) throws IOException {
        if (moduleRepository.save(module) == null) {
            throw new IllegalStateException("Error al guardar en la BD");
        }
        return "Se guardó correctamente el Modúlo";
    }
    
    @Override
    public void updateModuleById(Long id, Module module) throws IOException {
        Module updatedModule = moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));

        // updatedModule.setModuleName(module.getModuleName());
        updatedModule.setDescription(module.getDescription());
        updatedModule.setStartDate(module.getStartDate());
        updatedModule.setModuleCompletedDate(module.getModuleCompletedDate());
        // updatedModule.getLevel().add(Level.valueOf(module.getLevel()));
        
        // updatedModule.setExercises(module);
        Module moduleUpdated = moduleRepository.save(updatedModule);
        if (moduleUpdated == null) {
            throw new IllegalStateException("Error al actualizar la BD");
        }
    }
    
    @Override
    public void deleteModuleById(Long id) throws IOException {
        Module deletedModule = moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));
        moduleRepository.delete(deletedModule);

    }

}
