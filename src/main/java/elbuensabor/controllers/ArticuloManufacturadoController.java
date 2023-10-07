package elbuensabor.controllers;

import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.services.ArticuloManufacturadoServiceImpl;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/buscarArticuloManufacturadoPorDenominacionPaged")
    public ResponseEntity<?> buscarArticuloManufacturadoNativePaged(@RequestParam String denominacion, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarArticuloManufacturadoPorDenominacion(denominacion,pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


    @GetMapping("/filtroPorRubro")
    public ResponseEntity<?> filtroPorRubro(@RequestParam String denominacionRubro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtroPorRubroNative(denominacionRubro));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/filtradoPorPrecioDesc")
    public ResponseEntity<?> filtradoPorPrecioDesc(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorPrecioDesc());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));
        }
    }
    @GetMapping("/filtradoPorPrecioAsc")
    public ResponseEntity<?> filtradoPorPrecioAsc(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorPrecioAsc());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));
        }
    }



}
