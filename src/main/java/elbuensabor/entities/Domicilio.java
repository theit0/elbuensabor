package elbuensabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private Date fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    @Column(name = "fechaModificacion")
    private Date fechaModificacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
}
