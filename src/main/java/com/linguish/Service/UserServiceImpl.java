package com.linguish.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.User;
import com.linguish.Interface.IUserService;
import com.linguish.Repository.ExercisesRepository;
import com.linguish.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    
    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }
    
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado en la BD"));
    }
    
    @Override
    public String saveUser(User user) throws IOException {
        User newUser = userRepository.save(user);
        if (newUser == null) {
            throw new IllegalStateException("Error: No se pudo guardar el usuario");
        }
        return "Se guardo correctamente el usuario";
    }
    
    @Override
    public void updateUserById(Long id, User user) throws IOException {
        
        User updatedUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado en la BD"));
        updatedUser.setEmail(null);
        updatedUser.setPassword(null);
        updatedUser.setUserName(null);
        updatedUser.setProgressList(null);
        User usuario = userRepository.save(updatedUser);
        if (usuario == null) {
            throw new IllegalStateException("Error: No se pudo actualizar el usuario");
        }
    }
    
    @Override
    public void deleteUserById(Long id) throws IOException {
        User deletedUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado en la BD"));
        userRepository.delete(deletedUser);
    }
}
