package elbuensabor.repositories;

import elbuensabor.DTO.ArticuloManufacturadoDTO;
import elbuensabor.DTO.ClienteDTO;
import elbuensabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Query(
            value = "SELECT a.denominacion, SUM(d.cantidad) AS cantidad_productos_vendidos " +
                    "FROM articulo_manufacturado a " +
                    "INNER JOIN detalle_factura d ON a.id = d.id_articulo_manufacturado " +
                    "GROUP BY a.denominacion " +
                    "ORDER BY cantidad_productos_vendidos DESC",
            nativeQuery = true
    )
    List<ArticuloManufacturadoDTO> filtroPorProductoVendido();


    @Query(
            value = "SELECT a.denominacion, SUM(d.cantidad) AS cantidad_productos_vendidos " +
                    "FROM articulo_manufacturado a " +
                    "INNER JOIN detalle_factura d ON a.id = d.id_articulo_manufacturado " +
                    "INNER JOIN factura f ON d.id_factura = f.id "+
                    "WHERE f.fecha_facturacion BETWEEN :filtro1 AND :filtro2 " +
                    "GROUP BY a.denominacion " +
                    "ORDER BY cantidad_productos_vendidos DESC",
            nativeQuery = true
    )
    List<ArticuloManufacturadoDTO> filtradoPorProductoVendidoPorFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);
}
