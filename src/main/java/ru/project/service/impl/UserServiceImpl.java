package ru.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.model.entity.Phone;
import ru.project.model.entity.User;
import ru.project.model.protocol.UserPhoneProtocol;
import ru.project.model.protocol.UserProtocol;
import ru.project.repository.UserRepository;
import ru.project.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис, управляющий пользователями
 * Created by averizhnikov on 25.08.2016.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserPhoneProtocol> getUserPhoneProtocols() {

        List<UserPhoneProtocol> result = new ArrayList<>();

        for (User user : userRepository.findAll()) {
            result.add(
                    new UserPhoneProtocol(
                            user.getName(),
                            getPhoneNumberList(user.getId())
                    )
            );
        }

        return result;
    }

    private List<String> getPhoneNumberList(Integer userId) {
        List<String> result = new ArrayList<>();
        for (Phone phone : userRepository.getOne(userId).getPhones()) {
            if (phone.getNumber() != null)
                result.add(phone.getNumber());
        }
        return result;
    }

    @Override
    public User addUser(UserProtocol userProtocol) {
        User user = new User();
        user.setName(userProtocol.getName());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.delete(userId);
    }
}
