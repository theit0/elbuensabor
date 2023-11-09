package elbuensabor.repositories;

import elbuensabor.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{
    Optional<Usuario> findByUsername(String username);

    @Query(
            value = "SELECT * FROM usuario WHERE asusername LIKE %:filtro%",
            nativeQuery = true
    )
    List<Usuario> buscarUsuarioPorUserName(@Param("filtro") String username);



}
