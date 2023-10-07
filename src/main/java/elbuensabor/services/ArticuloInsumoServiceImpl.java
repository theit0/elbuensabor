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
    private elbuensabor.repositories.ArticuloManufacturadoRepository articuloManufacturadoRepository;
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
    }


}
