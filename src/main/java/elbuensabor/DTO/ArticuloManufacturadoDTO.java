package elbuensabor.DTO;


import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="filtroPorProductos",
        entities = {
                @EntityResult(
                        entityClass = ArticuloManufacturadoDTO.class,
                        fields = {
                                @FieldResult(name="denominacion", column = "denominacion"),
                                @FieldResult(name ="cantidad_productos_vendidos", column = "cantidad_productos_vendidos")
                        }
                )
        }
)
public interface ArticuloManufacturadoDTO {
    String getdenominacion();
    Integer getcantidad_productos_vendidos();
}