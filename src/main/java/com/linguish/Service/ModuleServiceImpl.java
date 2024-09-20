package com.linguish.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.Module;
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
    public List<Module> getRegisters() {
        return moduleRepository.findAll();
    }
    
    @Override
    public Module getRegisterById(Long id) {
        return moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));
    }
    
    @Override
    public Module saveRegister(Module newRegister) {
        return moduleRepository.save(newRegister);
    }
    
    @Override
    public Module updateRegisterById(Long id, Module updatedRegister) {
        Module updatedModule = moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encuentra el modulo en la BD"));

        updatedModule.setTitle(updatedRegister.getTitle());
        updatedModule.setDescription(updatedRegister.getDescription());
        updatedModule.setLevel(updatedRegister.getLevel()); 

        return moduleRepository.save(updatedModule);
    }
    
    @Override
    public void deleteRegisterById(Long id) {
        Module moduleDeleted = moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        moduleRepository.delete(moduleDeleted);
    }

}
