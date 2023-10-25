package elbuensabor.services;

import elbuensabor.entities.Factura;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura,Long> implements FacturaService{
    @Autowired
    FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura,Long> baseRepository, FacturaRepository facturaRepository){
        super(baseRepository);
    }
@Override
    @Transactional
    public void FacturarPedido(Long id) throws Exception {
        try {
            //facturaRepository.FacturarPedido(id);
            Factura f = facturaRepository.FacturarPedido(id);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
