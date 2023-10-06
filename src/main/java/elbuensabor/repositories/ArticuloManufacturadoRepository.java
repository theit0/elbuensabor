package elbuensabor.repositories;

import elbuensabor.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long>{

    //Filtrar articulos por su denominacion
    @Query(
            value = "SELECT * FROM Articulo_Manufacturado WHERE Articulo_Manufacturado.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloManufacturado> busquedaPorDenominacion(@Param("filtro")String filtro);
    //Ordenar articulos por su precio(mayor a menor)
    @Query(
            value = "SELECT * FROM Articulo_Manufacturado ORDER BY Articulo_Manufacturado.precio_venta DESC",
            nativeQuery = true
    )
    List<ArticuloManufacturado> filtradoPorPrecioDesc();
    //Ordenar articulos por su precio(menor a mayor)
    @Query(
            value = "SELECT * FROM Articulo_Manufacturado ORDER BY Articulo_Manufacturado.precio_venta",
            nativeQuery = true
    )
    List<ArticuloManufacturado> filtradoPorPrecioAsc();
}
