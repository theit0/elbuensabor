package elbuensabor.services;

import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.entities.RubroArticulo;
import elbuensabor.repositories.ArticuloManufacturadoRepository;
import elbuensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<ArticuloManufacturado> buscarArticuloManufacturadoPorDenominacion(String denominacion) throws Exception{
        try {
            return articuloManufacturadoRepository.buscarArticuloManufacturadoPorDenominacion(denominacion.toLowerCase());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> buscarArticuloManufacturadoPorDenominacion(String denominacion, Pageable pageable) throws Exception{
        try {
            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.buscarArticuloManufacturadoPorDenominacion(denominacion,pageable);
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<ArticuloManufacturado> filtroPorRubroNative(String denominacionRubro) throws Exception {
        try {
            return articuloManufacturadoRepository.filtroPorRubroNative(denominacionRubro);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}