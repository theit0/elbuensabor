package elbuensabor.DTO;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(
        name="filtroPorPedidos",
        entities = {
                @EntityResult(
                        entityClass = ClienteDTO.class,
                        fields = {
                                @FieldResult(name="apellido", column = "apellido"),
                                @FieldResult(name="nombre",column = "nombre"),

                        }
                )
        }
)
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClienteDTO {

    private String nombre;
    private String apellido;

}

