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

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/module")
@AllArgsConstructor
public class ModuleController {

    private final IModuleService moduleService;
    
    @Operation(summary = "Obtener todos los módulos", description = "Este endpoint devuelve una lista de todos los módulos registrados.")
    @GetMapping("/find/all")
    public ResponseEntity<List<Module>> findAllModules(){
        return new ResponseEntity<>(moduleService.getRegisters(), HttpStatus.OK);
    }
    
    @Operation(summary = "Obtener un módulo por su ID", description = "Este endpoint obtiene la información de un módulo basado en su ID.")
    @GetMapping("/find/{id}")
    public ResponseEntity<Module> findModule(@PathVariable Long id){
        return new ResponseEntity<>(moduleService.getRegisterById(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo módulo", description = "Este endpoint permite crear un nuevo módulo de ingles") 
    @PostMapping("/save")
    public ResponseEntity<Module> saveModule(@RequestBody Module module){
        return new ResponseEntity<>(moduleService.saveRegister(module), HttpStatus.OK);
    }

    @Operation(summary = "Actualizar un módulo por su ID", description = "Este endpoint permite actualizar la información de un módulo existente proporcionando su ID.")
    @PutMapping("/update/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module){
        return new ResponseEntity<>(moduleService.updateRegisterById(id, module) , HttpStatus.OK);
    }
    
    @Operation(summary = "Eliminar un módulo por su ID", description = "Este endpoint elimina un módulo basado en su ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id){
        moduleService.deleteRegisterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
