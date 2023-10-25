package elbuensabor.DTO;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="filtroPorPedidos",
        entities = {
                @EntityResult(
                        entityClass = ClienteDTO.class,
                        fields = {
                                @FieldResult(name="apellido", column = "apellido"),
                                @FieldResult(name="nombre",column = "nombre"),
                                @FieldResult(name ="cantidad_pedidos", column = "cantidad_pedidos")


                        }
                )
        }
)

public interface ClienteDTO {

    String getnombre();
    String getapellido();
    Integer getcantidad_pedidos();


}

