package elbuensabor.Repositories;

import elbuensabor.entities.Cliente;
import elbuensabor.repositories.ClienteRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ClienteRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ClienteRepository clienteRepository;
    @Test
    void testBuscarPorNyA(){
        Cliente cliente = new Cliente();
        cliente.setNombre("giovanni");
        cliente.setApellido("cirrincione");

        List<Cliente> listaEnviada = new ArrayList();
        listaEnviada.add(cliente);

        entityManager.persist(cliente);
        entityManager.flush();

        assertEquals(listaEnviada, clienteRepository.BuscarPorNyA("giovanni"));
        assertEquals(listaEnviada, clienteRepository.BuscarPorNyA("cirrincione"));

    }
}
