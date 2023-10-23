package elbuensabor.services;

import elbuensabor.DTO.MovimientosMonetariosDTO;
import elbuensabor.entities.Pedido;

import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long>{
    List<Pedido> BusquedaPedidoPorEstado(String filtro) throws Exception;
    List<Pedido> BusquedaPedidoAConfirmar() throws Exception;
    MovimientosMonetariosDTO MovimientoMonetario() throws Exception;

}
