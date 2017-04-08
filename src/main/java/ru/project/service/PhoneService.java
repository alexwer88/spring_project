package ru.project.service;

import ru.project.model.entity.Phone;
import ru.project.model.protocol.PhoneProtocol;

/**
 * Created by user on 30.09.16.
 */
public interface PhoneService {

    Phone addPhone(PhoneProtocol phoneProtocol);

    void deletePhone(Integer phoneId);


}
