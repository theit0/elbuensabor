package elbuensabor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario extends Base{
    @Column(name = "asusername")
    private String asusername;
    @Column(name = "auth0_id")
    private int auth0_id;
    @Column(name = "fechaAlta")
    private Date fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    @Column(name = "fechaModificacion")
    private Date fechaModificacion;
}
