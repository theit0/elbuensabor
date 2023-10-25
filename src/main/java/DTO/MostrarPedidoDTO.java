package DTO;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="mostrarEstadoPedido",
        entities = {
                @EntityResult(
                        entityClass = MostrarPedidoDTO.class,
                        fields = {
                                @FieldResult(name="id", column = "id"),
                                @FieldResult(name="tiempo_estimado_entrega",column = "tiempo_estimado_entrega"),



                        }
                )
        }
)
public interface MostrarPedidoDTO {
    Long getid();
    Integer gettiempo_estimado_entrega();

}
