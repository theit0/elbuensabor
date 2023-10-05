package elbuensabor.services;

import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.repositories.ArticuloManufacturadoRepository;
import elbuensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService {
    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
    }
    @Override
    public List<ArticuloManufacturado> busquedaPorDenominacion(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados= articuloManufacturadoRepository.busquedaPorDenominacion(filtro);
            return articuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}