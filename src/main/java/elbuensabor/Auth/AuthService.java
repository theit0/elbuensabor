package elbuensabor.Auth;

import elbuensabor.entities.Rol;
import elbuensabor.entities.Cliente;
import elbuensabor.entities.Usuario;
import elbuensabor.jwt.JwtService;
import elbuensabor.repositories.ClienteRepository;
import elbuensabor.repositories.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        boolean isCLIENTE = user.getAuthorities().stream()
                .anyMatch(authority -> "CLI".equals(authority.getAuthority()));

        if (!isCLIENTE) {
            throw new Exception("El usuario no tiene el rol de CLIENTE");
        }
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.CLI)
                .fechaAlta(LocalDateTime.now())
                .build();
        usuarioRepository.save(user);
        Cliente cli = Cliente.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.mail)
                .telefono(request.telefono)
                .fechaAlta(LocalDateTime.now())
                .usuario(user)
                .build();

        clienteRepository.save(cli);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

    public AuthResponse registerEmpleado(RegisterRequest request) {
        Usuario user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.EMP)
                .fechaAlta(LocalDateTime.now())
                .build();
        usuarioRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

    public AuthResponse loginEmpleado(LoginRequest request) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        boolean isEmpleado = user.getAuthorities().stream()
                .anyMatch(authority -> "EMP".equals(authority.getAuthority()));

        if (!isEmpleado) {
            throw new Exception("El usuario no tiene el rol de empleado");
        }
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse LoginAdmin(RegisterRequest request) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        boolean isAdmin = user.getAuthorities().stream()
                .anyMatch(authority -> "ADMIN".equals(authority.getAuthority()));

        if (!isAdmin) {
            throw new Exception("El usuario no tiene el rol de ADMIN");
        }
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse registerAdmin(RegisterRequest request) {
        Usuario user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.ADMIN)
                .fechaAlta(LocalDateTime.now())
                .build();
        usuarioRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}