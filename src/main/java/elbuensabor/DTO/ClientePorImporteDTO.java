package elbuensabor.DTO;

import io.swagger.models.auth.In;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="filtroPorPedidos",
        entities = {
                @EntityResult(
                        entityClass = ClientePorImporteDTO.class,
                        fields = {
                                @FieldResult(name="apellido", column = "apellido"),
                                @FieldResult(name="nombre",column = "nombre"),
                                @FieldResult(name="importe_total",column = "importe_total"),


                        }
                )
        }
)
public interface ClientePorImporteDTO {
    String getnombre();
    String getapellido();
    Integer getimporte_total();

}
