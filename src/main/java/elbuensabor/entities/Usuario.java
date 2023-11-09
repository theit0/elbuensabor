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

    private String password;
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.name())));
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    }

