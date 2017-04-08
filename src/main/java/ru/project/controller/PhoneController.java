package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.project.model.protocol.PhoneProtocol;
import ru.project.service.PhoneService;
import javax.validation.constraints.NotNull;

/**
 * Created by user on 30.09.16.
 */

@RestController
@Validated
public class PhoneController {

    @Autowired
    private PhoneService phoneService;


    @RequestMapping(method = RequestMethod.POST, value = "/phone/add")
    @ResponseBody
    public void add(@NotNull @RequestBody PhoneProtocol phoneProtocol) {
         phoneService.addPhone(phoneProtocol);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/phone/delete/{phoneId}")
    @ResponseBody
    public void delete(@NotNull @PathVariable Integer phoneId) {
        phoneService.deletePhone(phoneId);
    }
}
