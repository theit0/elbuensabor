package elbuensabor.services;

import elbuensabor.DTO.MovimientosMonetariosDTO;
import elbuensabor.entities.Pedido;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long>{
    List<Pedido> BusquedaPedidoPorEstado(String filtro) throws Exception;
    List<Pedido> BusquedaPedidoAConfirmar() throws Exception;
    MovimientosMonetariosDTO MovimientoMonetario() throws Exception;
    MovimientosMonetariosDTO MovimientoMonetarioFecha(Date filtro1, Date filtro2) throws Exception;

}
