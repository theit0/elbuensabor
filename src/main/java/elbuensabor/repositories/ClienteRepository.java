package elbuensabor.repositories;

import elbuensabor.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
}
