package elbuensabor.repositories;

import elbuensabor.DTO.ClienteDTO;
import elbuensabor.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
    //ordenar cliente de mayor a menor segun su cant de pedidos
    @Query(
            value = "SELECT c.apellido, c.nombre, COUNT(p.id) AS cantidad_pedidos " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.id_cliente " +
                    "GROUP BY c.id " +
                    "ORDER BY cantidad_pedidos DESC",
            nativeQuery = true
    )
    List<ClienteDTO> filtroPorPedidos();

}