package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.repository.impl.ImeiRepositoryImpl;
import ru.project.service.ImeiService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.IOException;

/**
 * Created by aw on 08.04.2017.
 */

@RestController
@Validated
public class IMEIController {

    @Autowired
    private ImeiService imeiService;

    @RequestMapping("/group/getByImei")
    public String getImei(@NotNull @Size(min = 15, max = 16) String imei) {
        return imeiService.getGroupByImei(imei);
    }
}
