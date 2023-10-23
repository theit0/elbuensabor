package elbuensabor.services;

import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.repositories.ArticuloInsumoRepository;
import elbuensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ArticuloInsumo> busquedaPorAlta() throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.busquedaPorAlta();
            return articuloInsumos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
