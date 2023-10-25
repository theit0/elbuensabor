package elbuensabor.Services;

import elbuensabor.entities.Cliente;
import elbuensabor.repositories.ClienteRepository;
import elbuensabor.services.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTest {
    @MockBean
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteServiceImpl clienteService;
    @Test
    void testBuscarPorNyA() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setNombre("giovanni");
        cliente.setApellido("cirrincione");

        List<Cliente> listaEnviada = new ArrayList<>();
        listaEnviada.add(cliente);

        when(clienteRepository.BuscarPorNyA("giovanni")).thenReturn(listaEnviada);

        assertEquals(listaEnviada, clienteService.BuscarPorNyA("giovanni"));
    }

}
