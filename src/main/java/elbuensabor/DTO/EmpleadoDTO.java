package elbuensabor.DTO;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="filtarEmpleados",
        entities = {
                @EntityResult(
                        entityClass = MostrarPedidoDTO.class,
                        fields = {
                                @FieldResult(name="nombreCli", column = "nombreCli"),
                                @FieldResult(name="apellidoCli",column = "apellidoCli"),
                                @FieldResult(name = "emailCli",column = "emailCli"),
                                @FieldResult(name = "telefonoCli",column = "telefonoCli"),
                                @FieldResult(name = "calleCli",column = "calleCli"),
                                @FieldResult(name = "numeroCli",column = "numeroCli"),
                                @FieldResult(name = "localidadCli",column = "localidadCli"),
                        }
                )
        }
)
public interface EmpleadoDTO {
    String getnombreCli();
    String getapellidoCli();
    String getemailCli();
    String gettelefonoCli();
    String getcalleCli();
    int getnumeroCli();
    String getlocalidadCli();
}
