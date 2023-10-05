package elbuensabor.services;

import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.entities.ArticuloManufacturado;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{
    List<ArticuloInsumo> busquedaPorDenominacionA(String filtro) throws Exception;
}
