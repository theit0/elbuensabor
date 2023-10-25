package elbuensabor.services;

import elbuensabor.DTO.MovimientosMonetariosDTO;
import elbuensabor.DTO.PedidoDTO;
import elbuensabor.entities.Pedido;
import elbuensabor.entities.Usuario;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.PedidoRepository;
import elbuensabor.repositories.UsuarioRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoServiceRepository) {
        super(baseRepository);
    }

    @Override
    public List<Pedido> BusquedaPedidoPorEstado(String filtro) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.BusquedaPedidoPorEstado(filtro);
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<Pedido> BusquedaPedidoAConfirmar() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.BusquedaPedidoAConfirmar();
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MovimientosMonetariosDTO MovimientoMonetario() throws Exception {
        try {
            MovimientosMonetariosDTO movimientos = pedidoRepository.MovimientoMonetario();
            return movimientos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    @SneakyThrows
    @Override
    public MovimientosMonetariosDTO MovimientoMonetarioFecha(Date filtro1, Date filtro2) {
        try {
            MovimientosMonetariosDTO movimientos = pedidoRepository.MovimientoMonetarioFecha(filtro1, filtro2);
            return movimientos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Pedido> buscarPedidoEnDelivery() throws Exception {
        try {
            return pedidoRepository.buscarPedidoEnDelivery();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PedidoDTO mostrarDetallePedido(Long id) throws Exception {
        try {
           return pedidoRepository.mostrarDetallePedido(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public void actulizarEstadoEntregado(Long id) throws Exception {
        try {
            pedidoRepository.actulizarEstadoEntregado(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
