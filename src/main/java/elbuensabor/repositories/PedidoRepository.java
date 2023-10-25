package elbuensabor.repositories;

import elbuensabor.DTO.MovimientosMonetariosDTO;
import elbuensabor.DTO.PedidoDTO;
import elbuensabor.entities.Pedido;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {
    //Filtrar pedido por su estado
    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%",
            nativeQuery = true
    )
    List<Pedido> BusquedaPedidoPorEstado(@Param("filtro") String filtro);


    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado = 'A_CONFIRMAR'  ",
            nativeQuery = true
    )
    List<Pedido> BusquedaPedidoAConfirmar();

    @Query(
            value = "SELECT " +
                    "SUM(TOTAL) AS total_ingresos, " +
                    "SUM(TOTAL_COSTO) AS total_costos, " +
                    "SUM(TOTAL - TOTAL_COSTO) AS diferencia " +
                    "FROM pedido",
            nativeQuery = true
    )
    MovimientosMonetariosDTO MovimientoMonetario();

    @Query(
            value = "SELECT " +
                    "SUM(TOTAL) AS total_ingresos, " +
                    "SUM(TOTAL_COSTO) AS total_costos, " +
                    "SUM(TOTAL - TOTAL_COSTO) AS diferencia " +
                    "FROM pedido p "+
                    "WHERE " +
                    ":filtro1 < p.FECHA_PEDIDO " +
                    "AND p.FECHA_PEDIDO < :filtro2",
            nativeQuery = true
    )
    MovimientosMonetariosDTO MovimientoMonetarioFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);

    //HU 16
    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado = 'PENDIENTE_ENTREGA'",
            nativeQuery = true
    )
    List<Pedido> buscarPedidoEnDelivery();

    @Query(
            value = "SELECT c.nombre AS nombreCli, c.apellido AS apellidoCli, c.telefono AS telefonoCli, d.calle AS calleDomicilio, d.numero AS nroDomicilio, d.localidad AS localidadDomicilio " +
                    "FROM pedido p " +
                    "INNER JOIN cliente c ON c.id = p.id_cliente " +
                    "INNER JOIN domicilio d ON d.id = p.id_domicilio_entrega " +
                    "WHERE p.id = :id",
            nativeQuery = true
    )
    PedidoDTO mostrarDetallePedido(@RequestParam("id") Long id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE pedido SET pedido.estado = 'COMPLETADO' WHERE pedido.id = :id",
            nativeQuery = true
    )
    void actulizarEstadoEntregado(@Param("id") Long id);

}