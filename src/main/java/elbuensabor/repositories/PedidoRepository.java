package elbuensabor.repositories;

import elbuensabor.DTO.MovimientosMonetariosDTO;
import elbuensabor.entities.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long>{
    //Filtrar pedido por su estado
    @Query(
            value="SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%",
            nativeQuery = true
    )
    List<Pedido> BusquedaPedidoPorEstado(@Param("filtro")String filtro);


    @Query(
            value="SELECT * FROM pedido WHERE pedido.estado = 'A_CONFIRMAR'  ",
            nativeQuery = true
    )
    List<Pedido> BusquedaPedidoAConfirmar();
    @Query(
            value ="SELECT "+
            "SUM(TOTAL) AS total_ingresos, "+
            "SUM(TOTAL_COSTO) AS total_costos, "+
            "SUM(TOTAL - TOTAL_COSTO) AS diferencia "+
            "FROM pedido",
            nativeQuery = true
    )
    MovimientosMonetariosDTO MovimientoMonetario();
}
