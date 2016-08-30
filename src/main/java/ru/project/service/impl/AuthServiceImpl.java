package ru.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.model.entity.AuthEntity;
import ru.project.model.entity.UserEntity;
import ru.project.model.protocol.*;
import ru.project.model.protocol.Error;
import ru.project.repository.AuthRepository;
import ru.project.service.AuthService;
import ru.project.service.UserService;
import ru.project.utils.DateUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Сервис, реализующий аутентификацию пользователей
 * Created by averizhnikov on 25.08.2016.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthRepository authRepository;

    @Override
    public Protocol authUser(LoginCustomer loginCustomer) {
        UserEntity userEntity = userService.getUserEntity(loginCustomer.getData());
        if (userEntity == null) {
            return new ErrorResponse(
                    loginCustomer.getSequenceId(),
                    new Error("Customer not found", "customer.notFound")
            );
        }
        Token token = buildToken();
        saveToken(
                token,
                loginCustomer,
                userEntity
        );
        return new CustomerApiToken(loginCustomer.getSequenceId(), token);
    }

    @Transactional
    private void saveToken(Token token, LoginCustomer loginCustomer, UserEntity userEntity) {

        setNotActiveTokensByDate(new Date());

        authRepository.saveAndFlush(
                new AuthEntity(
                        loginCustomer.getSequenceId(),
                        new Date(),
                        "Auth ok",
                        token.getToken(),
                        token.getTokenExpirationDate(),
                        userEntity
                )
        );
    }

    private Token buildToken() {
        return new Token(UUID.randomUUID().toString(), DateUtils.addDay(new Date(), 14));
    }

    @Transactional
    private void setNotActiveTokensByDate(Date date) {
        List<AuthEntity> authEntityList = authRepository.findActiveTokens(date);
        if (authEntityList == null || authEntityList.isEmpty()) {
            return;
        }
        authEntityList.forEach((authEntity) -> {
            authEntity.setTokenExpirationDate(new Date());
            authRepository.save(authEntity);
        });
        authRepository.flush();
    }

}
