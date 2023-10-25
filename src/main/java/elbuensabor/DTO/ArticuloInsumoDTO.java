package elbuensabor.DTO;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

import java.math.BigDecimal;

@SqlResultSetMapping(
        name="articulosBajosDeStock",
        entities = {
                @EntityResult(
                        entityClass = ArticuloInsumoDTO.class,
                        fields = {
                                @FieldResult(name="articuloDenominacion", column = "articuloDenominacion"),
                                @FieldResult(name="unidadDenominacion", column = "unidadDenominacion"),
                                @FieldResult(name="stock_minimo",column = "stock_minimo"),
                                @FieldResult(name="stock_actual",column = "stock_actual"),
                                @FieldResult(name = "diferencia", column = "diferencia")
                        }
                )
        }
)
public interface ArticuloInsumoDTO {
    String getarticuloDenominacion();
    String getunidadDenominacion();
    BigDecimal getstock_actual();
    BigDecimal getstock_minimo();
    BigDecimal getdiferencia();
}
