package elbuensabor.repositories;


import elbuensabor.DTO.ClienteDTO;
import elbuensabor.DTO.ClientePorImporteDTO;
import elbuensabor.DTO.EmpleadoDTO;
import elbuensabor.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
    //ordenar cliente de mayor a menor segun su cant de pedidos
    @Query(
            value = "SELECT c.nombre, c.apellido, c.email, c.telefono, d.numero, d.localidad, d.calle " +
                    "FROM cliente c " +
                    "LEFT JOIN domicilio d ON c.id = d.id_cliente " +
                    "LEFT JOIN usuario u ON u.id = c.id_usuario " +
                    "WHERE u.rol = 'EMP'",
            nativeQuery = true
    )
    List<ClienteDTO> filtroPorPedidos();
    //Ordenar cliente de mayor a menos segun su importe total
    @Query(
            value = "SELECT c.nombre, C.apellido, SUM(p.total) AS importe_total " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.id_cliente " +
                    "GROUP BY c.id " +
                    "ORDER BY importe_total DESC",
            nativeQuery = true
    )
    List<ClientePorImporteDTO>filtroPorImporte();
    //Ordenar cliente de mayot a menor entre 2 fechas segun su cant de pedidos
    @Query(
            value = "SELECT c.apellido, c.nombre, COUNT(p.id) AS cantidad_pedidos " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.id_cliente " +
                    "WHERE " +
                    ":filtro1 < p.FECHA_PEDIDO " +
                    "AND p.FECHA_PEDIDO < :filtro2 " +
                    "GROUP BY c.id " +
                    "ORDER BY cantidad_pedidos DESC",
            nativeQuery = true
    )
    List<ClienteDTO> filtroPorPedidosFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);
    //Ordenar cliente de mayot a menor entre 2 fechas segun su Importe de pedidos
    @Query(
            value = "SELECT c.nombre, C.apellido, SUM(p.total) AS importe_total " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.id_cliente " +
                    "WHERE " +
                    ":filtro1 < p.FECHA_PEDIDO " +
                    "AND p.FECHA_PEDIDO < :filtro2 " +
                    "GROUP BY c.id " +
                    "ORDER BY importe_total DESC",
            nativeQuery = true
    )
    List<ClientePorImporteDTO>filtroPorImporteFechas(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);
    @Query(
            value= "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro%",
            nativeQuery = true
    )
     public List<Cliente> BuscarPorNyA(@Param("filtro")String filtro);

    //Buscar clientes, con rol de emmpleado
    @Query(
            value = "SELECT c.nombre AS nombreCli, c.apellido AS apellidoCli, c.email AS emailCli, c.telefono AS telefonoCli, " +
                    "d.numero AS numeroCli, d.localidad AS localidadCli, d.calle AS calleCli " +
                    "FROM cliente c " +
                    "LEFT JOIN domicilio d ON c.id = d.fk_cliente " +
                    "LEFT JOIN usuario u ON u.id = c.fk_usuario " +
                    "WHERE u.rol = 'EMP'",
            nativeQuery = true
    )
    public List<EmpleadoDTO> filtrarEmpleados();

}