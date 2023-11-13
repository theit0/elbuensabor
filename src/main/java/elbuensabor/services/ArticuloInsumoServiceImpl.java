package elbuensabor.services;

import elbuensabor.DTO.ArticuloInsumoDTO;
import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.repositories.ArticuloInsumoRepository;
import elbuensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo,Long> implements ArticuloInsumoService {

    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
    }


    @Override
    public List<ArticuloInsumo> busquedaPorDenominacionA(String filtro) throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.busquedaPorDenominacionA(filtro);
            return articuloInsumos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloInsumo> busquedaPorAltaI() throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.busquedaPorAltaI();
            return articuloInsumos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloInsumoDTO> mostrarArticulosBajosDeStock(BigDecimal porcent) throws Exception{
        try {
            List<ArticuloInsumoDTO> articuloInsumos = articuloInsumoRepository.mostrarArticulosBajosDeStock(porcent);
            return articuloInsumos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
