package elbuensabor.Repositories;

import elbuensabor.entities.Cliente;
import elbuensabor.entities.Usuario;
import elbuensabor.repositories.ClienteRepository;
import elbuensabor.repositories.UsuarioRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class UsuarioRepositoryTest {

        @Autowired
        private EntityManager entityManager;

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Test
        void testBuscarUsuarioPorUsername() {
            Usuario usuario = new Usuario();
            usuario.setAsusername("theit0");

            List<Usuario> listaEnviada = new ArrayList();
            listaEnviada.add(usuario);

            entityManager.persist(usuario);
            entityManager.flush();

            assertEquals(listaEnviada, usuarioRepository.buscarUsuarioPorUserName("theit0"));

    }
}
