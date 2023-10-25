package elbuensabor.Controllers;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import elbuensabor.repositories.RubroArticuloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;



import elbuensabor.entities.Cliente;
import elbuensabor.services.ClienteServiceImpl;


@WebMvcTest(ClienteControllerTest.class)
public class ClienteControllerTest {
    @MockBean
    private ClienteServiceImpl clienteService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testBuscarPorNyA() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setNombre("giovanni");
        cliente.setApellido("cirrincione");

        List<Cliente> listaEnviada = new ArrayList();
        listaEnviada.add(cliente);

        when(clienteService.BuscarPorNyA("giovanni")).thenReturn(listaEnviada);

        mockMvc.perform(get("/api/v1/clientes/filtradoPorNyA")
                .param("filtro", "giovanni")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("giovanni")))
                .andExpect(jsonPath("$[0].apellido", is("cirrincione")));

    }

}
