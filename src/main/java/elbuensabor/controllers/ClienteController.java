package elbuensabor.controllers;

import elbuensabor.entities.Cliente;
import elbuensabor.services.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente,ClienteServiceImpl> {
    @GetMapping("/busquedaPorAltaC")
    public ResponseEntity<?> busquedaPorAltaC() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.busquedaPorAltaC());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }
    @GetMapping("/filtradoPorPedidos")
    public ResponseEntity<?> filtradoPorPedidos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorPedidos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }

    @GetMapping("/filtradoPorImporte")
    public ResponseEntity<?> filtradoPorImporte() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorImporte());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }

    @GetMapping("/filtradoPorPedidosFecha")
    public ResponseEntity<?> filtroPorPedidosFecha(@RequestParam Date filtro1, @RequestParam Date filtro2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtroPorPedidosFecha(filtro1, filtro2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }

    @GetMapping("/filtradoPorImporteFecha")
    public ResponseEntity<?> filtroPorImporteFechas(@RequestParam Date filtro1, @RequestParam Date filtro2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorImporteFechas(filtro1,filtro2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }
    @GetMapping("/filtradoPorNyA")
    public ResponseEntity<?> BuscarPorNyA(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.BuscarPorNyA(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }
}