package elbuensabor.services;

import elbuensabor.entities.DetalleArticuloManufacturado;
import elbuensabor.entities.DetallePedido;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.DetalleArticuloManufacturadoRepository;
import elbuensabor.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado,Long> implements DetalleArticuloManufacturadoService{
    @Autowired
    DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;
    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository) {
        super(baseRepository);

    }
}
