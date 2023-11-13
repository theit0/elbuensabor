package elbuensabor.repositories;

import elbuensabor.DTO.ArticuloInsumoDTO;
import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long>{

    //Filtrar articulos por su denominacion
    @Query(
            value = "SELECT * FROM Articulo_Insumo WHERE Articulo_Insumo.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloInsumo> busquedaPorDenominacionA(@Param("filtro")String filtro);



    @Query(
            value = "SELECT * FROM Articulo_Insumo WHERE Articulo_Insumo.FECHA_BAJA IS NULL",
            nativeQuery = true
    )
    List<ArticuloInsumo> busquedaPorAltaI();

    @Query(
            value = "SELECT a.denominacion, u.denominacion, a.stock_minimo, a.stock_actual, (a.stock_actual - a.stock_minimo) AS diferencia " +
                    "FROM Articulo_Insumo a " +
                    "LEFT JOIN Unidad_Medida u ON a.id_unidad_medida = u.ID " +
                    "WHERE a.stock_actual <= (a.stock_minimo * :porcent)",
            nativeQuery = true
    )
    List<ArticuloInsumoDTO> mostrarArticulosBajosDeStock(@RequestParam("porcent") BigDecimal porcent);

}
