package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import ru.project.model.protocol.Protocol;
import ru.project.model.protocol.LoginCustomer;
import ru.project.service.AuthService;

import javax.validation.Valid;

@Controller
@Validated
public class LoginController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private AuthService authService;

    @MessageMapping("/login")
    @SendTo("/topic/login")
    public Protocol authUser(@Valid LoginCustomer loginCustomer) throws Exception {
        return authService.authUser(loginCustomer);
    }


}
