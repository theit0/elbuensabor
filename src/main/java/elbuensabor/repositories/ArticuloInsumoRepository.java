package elbuensabor.repositories;

import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
    List<ArticuloInsumo> busquedaPorAlta();
}
