package elbuensabor.controllers;

import elbuensabor.entities.Factura;
import elbuensabor.services.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/factura")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{
  @PostMapping("/Facturar")
    public ResponseEntity FacturarPedido(@RequestParam Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Factura Creada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }
}
