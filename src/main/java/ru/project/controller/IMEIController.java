package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.repository.ImeiRepositoryImpl;

import java.io.IOException;

/**
 * Created by aw on 08.04.2017.
 */

@RestController
public class IMEIController {

    @Autowired
    private ImeiRepositoryImpl imeiRepositoryImpl;

    @RequestMapping("/group/getByImei")
    public String getImei(String imei) throws IOException {
        return imeiRepositoryImpl.getGroup(imei);
    }
}
