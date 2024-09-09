package com.linguish.Controller;

import java.io.IOException;
import java.util.List;
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
    public List<User> findAllUsers(){
        return userService.getUser();
    }
    
    @GetMapping("/find/{id}")
    public User findUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) throws IOException{
       return userService.saveUser(user);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) throws IOException{
        userService.updateUserById(id, user);
    }
    

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) throws IOException{
        userService.deleteUserById(id);
    }

}
