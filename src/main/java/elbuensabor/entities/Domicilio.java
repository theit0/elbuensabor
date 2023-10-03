package elbuensabor.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Domicilio extends Base{
    @Column(name = "calle")
    private String calle;
    @Column(name = "codPostal")
    private int codPostal;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "numero")
    private int numero;
    @Column(name = "pisoDepto")
    private int pisoDepto;
    @Column(name = "fechaAlta")

    private LocalDateTime fechaAlta;
    @Column(name = "fechaBaja")

    private Date fechaBaja;
    @Column(name = "fechaModificacion")

    private Date fechaModificacion;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
}
