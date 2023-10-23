package elbuensabor.services;

import elbuensabor.DTO.ClienteDTO;
import elbuensabor.DTO.ClientePorImporteDTO;
import elbuensabor.entities.Cliente;

import java.util.Date;
import java.util.List;


public interface ClienteService extends BaseService<Cliente,Long> {
    List<ClienteDTO> filtradoPorPedidos() throws Exception;

    List<ClientePorImporteDTO> filtradoPorImporte() throws Exception;

    List<ClienteDTO> filtroPorPedidosFecha(Date filtro1, Date filtro2);
    List<ClientePorImporteDTO> filtradoPorImporteFechas(Date filtro1, Date filtro2) throws Exception;
}
