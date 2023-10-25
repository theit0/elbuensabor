package DTO;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="mostrarDetallePedido",
        entities = {
                @EntityResult(
                        entityClass = PedidoDTO.class,
                        fields = {
                                @FieldResult(name="nombreCli", column = "nombreCli"),
                                @FieldResult(name="apellidoCli", column = "apellidoCli"),
                                @FieldResult(name="telefonoCli",column = "telefonoCli"),
                                @FieldResult(name="calleDomicilio", column = "calleDomicilio"),
                                @FieldResult(name="nroDomicilio",column = "nroDomicilio"),
                                @FieldResult(name = "localidadDomicilio", column = "localidadDomicilio")
                        }
                )
        }
)
public interface PedidoDTO {
    String getnombreCli();
    String getapellidoCli();
    String gettelefonoCli();
    String getcalleDomicilio();
    int getnroDomicilio();
    String getlocalidadDomicilio();

}
