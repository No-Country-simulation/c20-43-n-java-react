package com.linguish.Controller;

import java.util.List;
import com.linguish.DTO.LoginRequest;
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

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    
    @Operation(summary = "Obtener todos los usuarios", description = "Este endpoint devuelve una lista de todos los usuarios registrados.")
    @GetMapping("/find/all")
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userService.getRegisters(), HttpStatus.OK);
    }
    
    @Operation(summary = "Obtener un usuario por su ID", description = "Este endpoint obtiene un usuario basado en su ID.")
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getRegisterById(id), HttpStatus.OK);
    }


    @Operation(summary = "Crear un nuevo usuario", description = "Este endpoint permite crear un nuevo usuario proporcionando los datos requeridos.")
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
       return new ResponseEntity<>(userService.saveRegister(user), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un usuario por su ID", description = "Este endpoint permite actualizar la información de un usuario existente proporcionando su ID.")
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateRegisterById(id, user), HttpStatus.OK);
    }
    
    @Operation(summary = "Eliminar un usuario por su ID", description = "Este endpoint elimina un usuario basado en su ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteRegisterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest){
        boolean isAuthenticated = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}
