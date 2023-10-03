package elbuensabor.entities;

import elbuensabor.Enumerations.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Factura extends Base{
    @NotNull
    @Column(name = "fecha_facturacion")

    private LocalDateTime fechaFacturacion;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    @Column(name = "total_venta", precision = 10, scale = 2)
    private BigDecimal totalVenta;
    @Column(name = "fechaAlta")

    private LocalDateTime fechaAlta;
    @Column(name = "fechaBaja")

    private Date fechaBaja;
    @Column(name = "fechaModificacion")

    private Date fechaModificacion;



    @NotNull
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
