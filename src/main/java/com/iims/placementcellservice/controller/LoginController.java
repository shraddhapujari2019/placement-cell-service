package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.nio.file.Path;

@RestController()
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/login")
    void validateLogin(@PathParam("userid") int userId, @PathParam("password") String password) {

    }

    @PostMapping("/admin-login")
    void validateAdminLogin(@PathParam("userid") int userId, @PathParam("password") String password) {

    }

    @PostMapping("/login/reset")
    void resetUserPassword(@PathParam("userid") int userId) {
        // Get confidential details from user  and validate them. Redirect to password reset page

    }

    @PostMapping("/admin-login/reset")
    void resetAdminPassword(@PathParam("userid") int userId) {
        // Get confidential details from user  and validate them. Redirect to password reset page


    }
}
