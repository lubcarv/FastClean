package dev.fastcleanapi.fastcleanapi.controller;

import dev.fastcleanapi.fastcleanapi.model.Login.AuthenticationDTO;
import dev.fastcleanapi.fastcleanapi.model.Login.Login;
import dev.fastcleanapi.fastcleanapi.model.Login.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import dev.fastcleanapi.fastcleanapi.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        UserDetails customUserDetails = (UserDetails) auth.getPrincipal();

        // Agora você pode acessar o fullName
        String fullName = customUserDetails.getUsername();
        return ResponseEntity.ok().body("Login realizado com sucesso!: " + fullName);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Login newUser = new Login(data.email(), encryptedPassword, data.fullName());  // Ensure fullName is set
        this.repository.save(newUser);

        return ResponseEntity.ok().body("Usuario registrado com sucesso!");
    }

}
