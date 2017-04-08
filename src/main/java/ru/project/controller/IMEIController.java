package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.exception.GroupNotFoundException;
import ru.project.model.Error;
import ru.project.service.ImeiService;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Контроллер обрабатывающий запросы для групп
 * Created by aw on 08.04.2017.
 */

@RestController
@Validated
public class IMEIController {

    @Autowired
    private ImeiService imeiService;


    /**
     * Метод, обрабатывающий запрос получения группы для IMEI
     *
     * @param imei IMEI
     * @return группа
     * @throws GroupNotFoundException возникает когда группа не найдена
     */
    @RequestMapping("/imei/{imei}/group")
    public String getImei(@PathVariable @NotNull @Size(min = 15, max = 16) String imei) {
        return imeiService.getGroupByImei(imei);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public Error handleGroupNotFoundException(Exception ex) {
        return new Error(1001, ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Error handlValidateException(ConstraintViolationException ex) {
        return new Error(0, "Not valid params");
    }

}
