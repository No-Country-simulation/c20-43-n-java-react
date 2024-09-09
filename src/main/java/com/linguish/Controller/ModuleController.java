package com.linguish.Controller;

import java.io.IOException;
import java.util.*;
import com.linguish.Entity.Module;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.linguish.Interface.IModuleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/module")
@AllArgsConstructor
public class ModuleController {

    private final IModuleService moduleService;
    
    @GetMapping("/find/all")
    public List<Module> findAllModules(){
        return moduleService.getModule();
    }
    
    @GetMapping("/find/{id}")
    public Module findModule(@PathVariable Long id){
        return moduleService.getModuleById(id);
    }

    @PostMapping("/save")
    public String saveModule(@RequestBody Module module) throws IOException{
        return moduleService.saveModule(module);
    }

    @PutMapping("/update/{id}")
    public void updateModule(@PathVariable Long id, @RequestBody Module module) throws IOException{
        moduleService.updateModuleById(id,module);
    }
    

    @DeleteMapping("/delete/{id}")
    public void deleteModule(@PathVariable Long id) throws IOException{
        moduleService.deleteModuleById(id);
    }
}
