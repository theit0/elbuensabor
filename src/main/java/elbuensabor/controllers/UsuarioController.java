package elbuensabor.controllers;

import elbuensabor.entities.Usuario;
import elbuensabor.services.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{



    @GetMapping("/buscarUsuarioPorUserName")
    public ResponseEntity<?> buscarUsuarioPorUserName(@RequestParam String username){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarUsuarioPorUserName(username));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }








}
