package elbuensabor.entities;

import elbuensabor.Enumerations.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario extends Base implements UserDetails {


    @Column(name = "username")
    private String username;

    @Column(name = "fechaAlta")

    private LocalDateTime fechaAlta;
    @Column(name = "fechaBaja")

    private Date fechaBaja;
    @Column(name = "fechaModificacion")

    private Date fechaModificacion;
    @Enumerated(EnumType.STRING)
    Rol rol;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.name())));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
