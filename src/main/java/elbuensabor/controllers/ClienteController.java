package elbuensabor.controllers;

import elbuensabor.entities.Cliente;
import elbuensabor.services.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente,ClienteServiceImpl>{


}
