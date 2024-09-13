package com.linguish.Controller;

import java.util.*;

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

import com.linguish.Entity.Progress;
import com.linguish.Interface.IProgressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/progress")
@AllArgsConstructor
public class ProgressController {

    private final IProgressService progressService;

    @GetMapping("/find/all")
    public ResponseEntity<List<Progress>> findAllProgress(){
        return new ResponseEntity<>(progressService.getRegisters(), HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Progress> findProgress(@PathVariable Long id){
        return new ResponseEntity<>(progressService.getRegisterById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Progress> saveProgress(@RequestBody Progress progress){
       return new ResponseEntity<>(progressService.saveRegister(progress), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long id, @RequestBody Progress progress){
        return new ResponseEntity<>(progressService.updateRegisterById(id, progress), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable Long id){
        progressService.deleteRegisterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
