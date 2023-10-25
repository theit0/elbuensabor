package elbuensabor.services;

import DTO.ArticuloInsumoDTO;
import elbuensabor.entities.ArticuloInsumo;

import java.math.BigDecimal;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{
    List<ArticuloInsumo> busquedaPorDenominacionA(String filtro) throws Exception;
    List<ArticuloInsumo> busquedaPorAlta() throws Exception;
    List<ArticuloInsumoDTO> mostrarArticulosBajosDeStock(BigDecimal porcent) throws Exception;
}
