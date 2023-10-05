package elbuensabor.controllers;

import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.services.ArticuloInsumoServiceImpl;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

