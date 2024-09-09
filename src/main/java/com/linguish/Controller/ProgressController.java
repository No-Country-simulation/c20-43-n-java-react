package com.linguish.Controller;

import java.io.IOException;
import java.util.*;
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
    public List<Progress> findAllProgress(){
        return progressService.getProgress();
    }
    
    @GetMapping("/find/{id}")
    public Progress findProgress(@PathVariable Long id){
        return progressService.getProgressById(id);
    }

    @PostMapping("/save")
    public String saveProgress(@RequestBody Progress progress) throws IOException{
        return progressService.saveProgress(progress);
    }

    @PutMapping("/update/{id}")
    public void updateProgress(@PathVariable Long id, @RequestBody Progress progress) throws IOException{
        progressService.updateProgressById(id, progress);
    }
    

    @DeleteMapping("/delete/{id}")
    public void deleteProgress(@PathVariable Long id) throws IOException{
        progressService.deleteProgressById(id);
    }


}
