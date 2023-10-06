package elbuensabor.services;

import elbuensabor.entities.ArticuloManufacturado;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado,Long>{
    List<ArticuloManufacturado> busquedaPorDenominacion(String filtro) throws Exception;
    List<ArticuloManufacturado> filtradoPorPrecioDesc() throws Exception;
    List<ArticuloManufacturado> filtradoPorPrecioAsc() throws Exception;
}
