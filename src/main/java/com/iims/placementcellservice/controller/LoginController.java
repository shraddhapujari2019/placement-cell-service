package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
@CrossOrigin(originPatterns = {"*"})

@RestController()
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }

    @PostMapping("/admin-login")
    ResponseEntity<String> adminLogin(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }
}
