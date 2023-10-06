package elbuensabor.services;

import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.entities.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado,Long>{
    List<ArticuloManufacturado> buscarArticuloManufacturadoPorDenominacion(String denominacion) throws Exception;
    Page<ArticuloManufacturado> buscarArticuloManufacturadoPorDenominacion(String denominacion, Pageable pageable) throws Exception;
    List<ArticuloManufacturado> filtroPorRubroNative(String denominacionRubro) throws Exception;

}
