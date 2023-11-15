package elbuensabor.Auth;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) throws Exception
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping(value = "/registerEmpleado")
    public ResponseEntity<AuthResponse> registerEmpleado(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping(value = "/loginEmpleado")
    public ResponseEntity<AuthResponse> loginEmpleado(@RequestBody LoginRequest request) throws Exception
    {
        return ResponseEntity.ok(authService.loginEmpleado(request));
    }
    @PostMapping(value = "/registerAdmin")
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerAdmin(request));
    }
    @PostMapping(value = "/loginAdmin")
    public ResponseEntity<AuthResponse> loginAdmin(@RequestBody RegisterRequest request) throws Exception {
        return ResponseEntity.ok(authService.LoginAdmin(request));
    }
}
