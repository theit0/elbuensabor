package elbuensabor.services;

import elbuensabor.entities.ArticuloManufacturado;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado,Long>{
    List<ArticuloManufacturado> buscarArticuloManufacturadoPorDenominacion(String denominacion) throws Exception;
}
