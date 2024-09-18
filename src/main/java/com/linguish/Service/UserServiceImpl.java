package com.linguish.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linguish.Entity.User;
import com.linguish.Interface.IUserService;
import com.linguish.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Transactional
    public List<User> getRegisters() {
        return userRepository.findAll();
    }
    
    @Transactional
    public User getRegisterById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado en la BD"));
    }
    
    @Transactional
    public User saveRegister(User newRegister) {
        return userRepository.save(newRegister);
    }
    
    @Transactional
    public User updateRegisterById(Long id, User updatedRegister) {
        User updatedUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado en la BD"));
<<<<<<< HEAD
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setUsername(user.getUsername());
        // updatedUser.setProgressList(user.getProgressList());
        User usuario = userRepository.save(updatedUser);
        if (usuario == null) {
            throw new IllegalStateException("Error: No se pudo actualizar el usuario");
        }
=======
        updatedUser.setEmail(updatedRegister.getEmail());
        updatedUser.setPassword(updatedRegister.getPassword());
        updatedUser.setUsername(updatedRegister.getUsername());
        updatedUser.setProgressList(updatedRegister.getProgressList());
        return userRepository.save(updatedUser);
>>>>>>> ecf9aa84f0b9346f8305c310dde50ba4117aa2e4
    }
    
    @Transactional
    public void deleteRegisterById(Long id) {
        User deletedUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado en la BD"));
        userRepository.delete(deletedUser);
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);

        return user != null && user.getPassword().equals(password);
    }
}
