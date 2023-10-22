package elbuensabor.services;

import elbuensabor.DTO.ClienteDTO;
import elbuensabor.entities.Cliente;

import java.util.List;


public interface ClienteService extends BaseService<Cliente,Long> {
    List<ClienteDTO> filtradoPorPedidos() throws Exception;
}
