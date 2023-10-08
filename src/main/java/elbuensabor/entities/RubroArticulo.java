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
<<<<<<< HEAD
    //@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_rubro_padre")
    //private RubroArticulo rubroPadre;

    // @OneToMany(mappedBy = "rubroPadre")
    // private List<RubroArticulo> subRubros;
=======
   // @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_rubro_padre")
    //private RubroArticulo rubroPadre;

    //@OneToMany(mappedBy = "rubroPadre")
    //private List<RubroArticulo> subRubros;
>>>>>>> 3c1e28eda01327a048741dd08fd45bdef932e7f7

    @NotNull
    private String denominacion;
    @Column(name = "fechaAlta")

    private LocalDateTime fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    @Column(name = "fechaModificacion")

    private Date fechaModificacion;



<<<<<<< HEAD
    //public RubroArticulo(String denominacion, RubroArticulo rubroPadre) {
    //    this.denominacion = denominacion;
    //    this.rubroPadre = rubroPadre;
    //}

    //public void setSubRubros(List<RubroArticulo> subRubros) {
    //    this.subRubros.clear();
    //    this.subRubros.addAll(subRubros);
=======
   // public RubroArticulo(String denominacion, RubroArticulo rubroPadre) {
     //   this.denominacion = denominacion;
       // this.rubroPadre = rubroPadre;
   // }

    //public void setSubRubros(List<RubroArticulo> subRubros) {
      //  this.subRubros.clear();
       // this.subRubros.addAll(subRubros);
>>>>>>> 3c1e28eda01327a048741dd08fd45bdef932e7f7
    //}
}
