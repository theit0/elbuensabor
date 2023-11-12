package elbuensabor.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "Articulo_Manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArticuloManufacturado extends Base{
    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;
    @Column(name = "fechaAlta")

    private LocalDateTime fechaAlta;
    @Column(name = "fechaBaja")

    private Date fechaBaja;
    @Column(name = "fechaModificacion")

    private Date fechaModificacion;
    @NotNull
    @JsonIgnore

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rubro_articulo")
    private RubroArticulo rubroArticulo;

}
