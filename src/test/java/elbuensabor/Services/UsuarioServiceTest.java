package elbuensabor.Services;


import elbuensabor.entities.Cliente;
import elbuensabor.entities.Usuario;
import elbuensabor.repositories.ClienteRepository;
import elbuensabor.repositories.UsuarioRepository;
import elbuensabor.services.ClienteServiceImpl;
import elbuensabor.services.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioServiceTest {

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Test
    void testBuscarUsuarioPorUserName() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setAsusername("theit0");


        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario);

        when(usuarioRepository.buscarUsuarioPorUserName("theit0")).thenReturn(listaEnviada);

        assertEquals(listaEnviada, usuarioService.buscarUsuarioPorUserName("theit0"));
    }


}
