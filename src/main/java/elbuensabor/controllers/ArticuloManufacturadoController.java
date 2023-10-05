package elbuensabor.controllers;

import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.services.ArticuloManufacturadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulosManufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{
    @GetMapping("/buscarArticuloManufacturadoPorDenominacion")
    public ResponseEntity<?> buscarArticuloManufacturadoNative(@RequestParam String denominacion){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarArticuloManufacturadoPorDenominacion(denominacion));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
