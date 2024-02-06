//package com.example.demo.restcontroller;
//
//import com.example.demo.models.entities.AuthenticationResponse;
//import com.example.demo.models.entities.Usuario;
//import com.example.demo.models.services.AuthenticationService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthenticationRestController {
//    private final AuthenticationService authService;
//
//    public AuthenticationRestController(AuthenticationService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody Usuario request
//            ) {
//        return ResponseEntity.ok(authService.register(request));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse> login(
//            @RequestBody Usuario request
//    ) {
//        return ResponseEntity.ok(authService.authenticate(request));
//    }
//}
