package com.linguish.Interface;

import com.linguish.Entity.Module;

import java.io.IOException;
import java.util.List;

public interface IModuleService {

    List<Module> getModule();

    Module getModuleById(Long id);

    String saveModule(Module module) throws IOException;

    void updateModuleById(Long id, Module module) throws IOException;

    void deleteModuleById(Long id) throws IOException;
}
