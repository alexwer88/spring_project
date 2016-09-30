package ru.project.service;

import ru.project.model.entity.User;
import ru.project.model.protocol.UserPhoneProtocol;
import ru.project.model.protocol.UserProtocol;

import java.util.List;


/**
 * Сервис, управляющий пользователями
 * Created by averizhnikov on 25.08.2016.
 */
public interface UserService {


    List<ru.project.model.entity.User> getAllUsers();

    List<UserPhoneProtocol> getUserPhoneProtocols();

    User addUser(UserProtocol userProtocol);

    void deleteUser(Integer userId);

}
