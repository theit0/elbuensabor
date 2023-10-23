package elbuensabor.controllers;

import elbuensabor.entities.Pedido;
import elbuensabor.services.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {
    @GetMapping("/busquedaPorEstado")
    public ResponseEntity<?> BusquedaPedidoPorEstado(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.BusquedaPedidoPorEstado(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }

    }


    @GetMapping("/busquedaPedidosAConfirmar")
    public ResponseEntity<?> BusquedaPedidoAConfirmar() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.BusquedaPedidoAConfirmar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }

    }

    @GetMapping("/MovimientosMonetarios")
    public ResponseEntity<?> MovimientoMonetarios() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.MovimientoMonetario());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }

    }
}
