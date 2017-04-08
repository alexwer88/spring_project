package ru.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.model.entity.Phone;
import ru.project.model.protocol.PhoneProtocol;
import ru.project.repository.PhoneRepository;
import ru.project.repository.UserRepository;
import ru.project.service.PhoneService;

/**
 * Created by user on 30.09.16.
 */
@Service
public class PhoneServiceImpl implements PhoneService {


    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Phone addPhone(PhoneProtocol phoneProtocol) {

        Phone phone = new Phone();
        phone.setUser(userRepository.getOne(phoneProtocol.getUserId()));
        phone.setNumber(phoneProtocol.getPhoneNumber());

        return phoneRepository.saveAndFlush(phone);
    }

    @Override
    public void deletePhone(Integer phoneId) {
        phoneRepository.delete(phoneId);
    }
}
