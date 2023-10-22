package elbuensabor.services;

import elbuensabor.entities.Pedido;
import elbuensabor.entities.Usuario;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.PedidoRepository;
import elbuensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService{
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
        }
         catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
