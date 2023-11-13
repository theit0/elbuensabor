package elbuensabor.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro_padre")
    private RubroArticulo rubroPadre;

    //@OneToMany(mappedBy = "rubroPadre")
    //private List<RubroArticulo> subRubros;

    @NotNull
    private String denominacion;
    @Column(name = "fechaAlta")

    private LocalDateTime fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    @Column(name = "fechaModificacion")

    private Date fechaModificacion;



   // public RubroArticulo(String denominacion, RubroArticulo rubroPadre) {
     //   this.denominacion = denominacion;
       // this.rubroPadre = rubroPadre;
   // }

    //public void setSubRubros(List<RubroArticulo> subRubros) {
      //  this.subRubros.clear();
       // this.subRubros.addAll(subRubros);
    //}
}
