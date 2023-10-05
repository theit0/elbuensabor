package elbuensabor.repositories;

import elbuensabor.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long>{
    @Query(
        value = "SELECT * FROM articulo_manufacturado WHERE denominacion LIKE %:filtro%",
        nativeQuery = true
    )
    List<ArticuloManufacturado> buscarArticuloManufacturadoPorDenominacion(@Param("filtro") String denominacion);
}
