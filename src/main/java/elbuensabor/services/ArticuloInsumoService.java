package elbuensabor.services;

import elbuensabor.DTO.ArticuloInsumoDTO;
import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.entities.ArticuloManufacturado;

import java.math.BigDecimal;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{
    List<ArticuloInsumo> busquedaPorAltaI() throws Exception;
    List<ArticuloInsumo> busquedaPorDenominacionA(String filtro) throws Exception;
    List<ArticuloInsumoDTO> mostrarArticulosBajosDeStock(BigDecimal porcent) throws Exception;

}
