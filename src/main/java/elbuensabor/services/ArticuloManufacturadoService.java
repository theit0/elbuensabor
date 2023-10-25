package elbuensabor.services;

import elbuensabor.DTO.ArticuloManufacturadoDTO;
import elbuensabor.entities.ArticuloManufacturado;

import java.util.Date;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado,Long>{
    List<ArticuloManufacturado> busquedaPorDenominacion(String filtro) throws Exception;
    List<ArticuloManufacturado> filtradoPorPrecioDesc() throws Exception;
    List<ArticuloManufacturado> filtradoPorPrecioAsc() throws Exception;

    List<ArticuloManufacturadoDTO> filtradoPorProductoVendido() throws Exception;
    List<ArticuloManufacturadoDTO> filtradoPorProductoVendidoPorFecha(Date filtro1, Date filtro2) throws Exception;
}
