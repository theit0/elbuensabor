package elbuensabor.controllers;

import elbuensabor.entities.Cliente;
import elbuensabor.services.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente,ClienteServiceImpl>{
    @GetMapping("/filtradoPorPedidos")
    public ResponseEntity<?> filtradoPorPedidos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorPedidos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));

        }
        }
    }

