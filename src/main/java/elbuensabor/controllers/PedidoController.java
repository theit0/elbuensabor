package elbuensabor.controllers;

import elbuensabor.entities.Pedido;
import elbuensabor.services.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    @GetMapping("/MovimientosMonetariosFecha")
    public ResponseEntity<?> MovimientoMonetariosFecha(@RequestParam Date filtro1, @RequestParam Date filtro2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.MovimientoMonetarioFecha(filtro1,filtro2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }

    }


    @GetMapping("/buscarPedidoEnDelivery")
    public ResponseEntity<?> buscarPedidoEnDelivery(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPedidoEnDelivery());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/mostrarDetallePedido")
    public ResponseEntity<?> mostrarDetallePedido(@RequestParam Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.mostrarDetallePedido(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PutMapping("/actulizarEstadoEntregado")
    public ResponseEntity<?> actulizarEstadoEntregado(Long id){
        try {
            servicio.actulizarEstadoEntregado(id);
            return ResponseEntity.status(HttpStatus.OK).body("El estado ha sido cambiado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
