package elbuensabor.controllers;

import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.services.ArticuloManufacturadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ArticuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{
    @GetMapping("/busquedaPorAlta")
    public ResponseEntity<?> busquedaPorAlta(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.busquedaPorAlta());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));

        }
    }
    @GetMapping("/busquedaPorDenominacion")
    public ResponseEntity<?> busquedaPorDenominacion(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.busquedaPorDenominacion(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));

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

    @GetMapping("/rankingProductos")
    public ResponseEntity<?> rankingProductos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorProductoVendido());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));
        }
    }

    @GetMapping("/rankingProductosPorFecha")
    public ResponseEntity<?> rankingProductosPorFecha(@RequestParam Date filtro1, @RequestParam Date filtro2){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorProductoVendidoPorFecha(filtro1,filtro2));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" +e.getMessage() +"\"}"));
        }
    }
}
