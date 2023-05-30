package com.ZahidHasan.securityJWT.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ZahidHasan.securityJWT.model.AuthResponseDto;
import com.ZahidHasan.securityJWT.model.LoginRequestDto;
import com.ZahidHasan.securityJWT.model.RegisterRequestDto;
import com.ZahidHasan.securityJWT.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping
  public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto registerRequestDto) {
    //return ResponseEntity.ok(authService.login(registerRequestDto));

    try {
      AuthResponseDto response = authService.login(registerRequestDto);
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      // Handle the exception and return an appropriate response or error message
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
  
  @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
    return ResponseEntity.ok(authService.register(registerRequestDto));
  }
}
