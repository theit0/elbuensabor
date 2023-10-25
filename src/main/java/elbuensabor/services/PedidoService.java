package elbuensabor.services;

import DTO.MostrarPedidoDTO;
import DTO.MovimientosMonetariosDTO;
import DTO.PedidoDTO;
import elbuensabor.entities.Pedido;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long>{
    List<Pedido> BusquedaPedidoPorEstado(String filtro) throws Exception;
    List<Pedido> BusquedaPedidoAConfirmar() throws Exception;
    MovimientosMonetariosDTO MovimientoMonetario() throws Exception;
    MovimientosMonetariosDTO MovimientoMonetarioFecha(Date filtro1, Date filtro2) throws Exception;

    List<Pedido> buscarPedidoEnDelivery() throws Exception;

    PedidoDTO mostrarDetallePedido(Long id) throws Exception;
    void actulizarEstadoEntregado(Long id) throws Exception;
    MostrarPedidoDTO mostrarEstadoPedido(Long id) throws Exception;


}
