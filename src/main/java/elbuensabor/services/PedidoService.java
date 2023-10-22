package elbuensabor.services;

import elbuensabor.entities.Pedido;

import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long>{
    List<Pedido> BusquedaPedidoPorEstado(String filtro) throws Exception;
}
