package com.linguish.Interface;

import java.util.List;

public interface IServices<T> {

    List<T> getRegisters();

    T getRegisterById(Long id);

    T saveRegister(T newRegister);

    T updateRegisterById(Long id, T updatedRegister);

    void deleteRegisterById(Long id);

}
