package br.com.adOptimize.api_adOptimize.controller;

import br.com.adOptimize.api_adOptimize.model.User;
import br.com.adOptimize.api_adOptimize.repository.UserRepository;
import br.com.adOptimize.api_adOptimize.dto.AuthDTO;
import br.com.adOptimize.api_adOptimize.dto.LoginResponseDTO;
import br.com.adOptimize.api_adOptimize.dto.RegisterDTO;
import br.com.adOptimize.api_adOptimize.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO) {
        // Gerar um token de usuário e senha
        var usuarioSenha = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.senha());
        // Autenticar esse token
        var auth = authenticationManager.authenticate(usuarioSenha);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (userRepository.findByLogin(registerDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());
        User user = new User(registerDTO.login(), encryptedPassword, registerDTO.role());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
