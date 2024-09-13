package com.linguish.Controller;

import java.util.*;
import com.linguish.Entity.Module;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Module>> findAllModules(){
        return new ResponseEntity<>(moduleService.getRegisters(), HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Module> findModule(@PathVariable Long id){
        return new ResponseEntity<>(moduleService.getRegisterById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Module> saveModule(@RequestBody Module module){
        return new ResponseEntity<>(moduleService.saveRegister(module), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module){
        return new ResponseEntity<>(moduleService.updateRegisterById(id, module) , HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id){
        moduleService.deleteRegisterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
