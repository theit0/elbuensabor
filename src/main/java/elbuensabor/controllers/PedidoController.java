package elbuensabor.controllers;

import elbuensabor.entities.Pedido;
import elbuensabor.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
}
