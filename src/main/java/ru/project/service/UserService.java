package ru.project.service;

import ru.project.model.entity.UserEntity;
import ru.project.model.protocol.User;


/**
 * Сервис, управляющий пользователями
 * Created by averizhnikov on 25.08.2016.
 */
public interface UserService {

    UserEntity getUserEntity(User user);
}
