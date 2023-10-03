package elbuensabor.services;

import elbuensabor.entities.Cliente;
import elbuensabor.entities.DetallePedido;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.ClienteRepository;
import elbuensabor.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido,Long> implements DetallePedidoService {
    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
        super(baseRepository);

    }
}
