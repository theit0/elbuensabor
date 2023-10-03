package elbuensabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
@Entity
@Table(name = "Detalle_Pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetallePedido extends Base{
    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @NotNull
    @Column(name = "subtotal_costo", precision = 10, scale = 2)
    private BigDecimal subtotalCosto;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_articulo_insumo")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @NotNull
    @ManyToOne(optional = false,cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}
