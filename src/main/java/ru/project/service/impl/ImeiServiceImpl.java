package ru.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.exception.GroupNotFoundException;
import ru.project.repository.ImeiRepository;
import ru.project.service.ImeiService;

/**
 * Created by aw on 08.04.2017.
 */

@Service
public class ImeiServiceImpl implements ImeiService {

    @Autowired
    private ImeiRepository imeiRepository;

    public String getGroupByImei(String imei) {
        String group = imeiRepository.getGroup(getTac(imei));
        if (group == null)
            throw new GroupNotFoundException(String.format("Group by imei [%s] not found", imei));
        return group;
    }

    private String getTac(String imei) {
        return imei.substring(0, 8);
    }
}
