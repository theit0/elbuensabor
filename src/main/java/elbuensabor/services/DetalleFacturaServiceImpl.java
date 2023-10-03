package elbuensabor.services;

import elbuensabor.entities.DetalleFactura;
import elbuensabor.entities.DetallePedido;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.DetalleFacturaRepository;
import elbuensabor.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura,Long> implements DetalleFacturaService{
    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;
    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository, DetalleFacturaRepository detalleFacturaRepository) {
        super(baseRepository);

    }

}
