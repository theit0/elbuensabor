package elbuensabor.controllers;

import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.services.ArticuloInsumoServiceImpl;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ArticuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{
    @GetMapping("/busquedaPorDenominacionA")
    public ResponseEntity<?> busquedaPorDenominacionA(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.busquedaPorDenominacionA(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));

        }
    }

    @GetMapping("/busquedaPorAlta")
    public ResponseEntity<?> busquedaPorAlta(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.busquedaPorAlta());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));

        }
    }

    @GetMapping("/mostrarArticulosBajosDeStock")
    public ResponseEntity<?> mostrarArticulosBajosDeStock(@RequestParam BigDecimal porcent){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.mostrarArticulosBajosDeStock(porcent));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));

        }
    }
}

