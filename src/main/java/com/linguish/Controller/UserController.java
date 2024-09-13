package com.linguish.Controller;

import java.util.List;

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

import com.linguish.Entity.User;
import com.linguish.Interface.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    
    @GetMapping("/find/all")
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userService.getRegisters(), HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getRegisterById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
       return new ResponseEntity<>(userService.saveRegister(user), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateRegisterById(id, user), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteRegisterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
