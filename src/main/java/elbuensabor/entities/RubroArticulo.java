package elbuensabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Rubro_Articulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroArticulo extends Base{


    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "fechaAlta")
    private LocalDateTime fechaAlta;

    @Column(name = "fechaBaja")
    private Date fechaBaja;

    @Column(name = "fechaModificacion")
    private Date fechaModificacion;



}
