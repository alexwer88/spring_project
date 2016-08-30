package ru.project.service;

import ru.project.model.protocol.Protocol;
import ru.project.model.protocol.LoginCustomer;

/**
 * Сервис, реализующий аутентификацию пользователей
 * Created by averizhnikov on 25.08.2016.
 */
public interface AuthService {

    Protocol authUser(LoginCustomer loginCustomer);
}
