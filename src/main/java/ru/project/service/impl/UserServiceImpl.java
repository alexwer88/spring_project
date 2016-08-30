package ru.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;
import ru.project.model.entity.UserEntity;
import ru.project.model.protocol.User;
import ru.project.repository.UserRepository;
import ru.project.service.UserService;

/**
 * Сервис, управляющий пользователями
 * Created by averizhnikov on 25.08.2016.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserEntity(User user) {
        return userRepository.findByEmailAndPasswordAndActiveTrue(
                user.getEmail(),
                encodeMD5(user.getPassword())
        );
    }

    private String encodeMD5(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return new String(
                Base64Utils.encode(
                        DigestUtils.md5Digest(value.getBytes())
                )
        );
    }

}
