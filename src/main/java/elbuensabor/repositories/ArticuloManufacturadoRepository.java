package elbuensabor.repositories;

import elbuensabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articulo_manufacturado",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> buscarArticuloManufacturadoPorDenominacion(@Param("filtro")String denominacion, Pageable page);
}
