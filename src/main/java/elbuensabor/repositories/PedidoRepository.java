package elbuensabor.repositories;

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
}
