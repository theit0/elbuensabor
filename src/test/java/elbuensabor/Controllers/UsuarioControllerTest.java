package elbuensabor.Controllers;


import elbuensabor.entities.Usuario;
import elbuensabor.services.ClienteServiceImpl;
import elbuensabor.services.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioControllerTest.class)
public class UsuarioControllerTest {


    @MockBean
    private UsuarioServiceImpl usuarioService;


    @Autowired
    private MockMvc mockMvc;

    @Test
    void testBuscarUsuarioPorUserName() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setAsusername("theit0");


        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario);

        when(usuarioService.buscarUsuarioPorUserName("theit0")).thenReturn(listaEnviada);

        mockMvc.perform(get("/api/v1/usuarios/buscarUsuarioPorUserName")
                        .param("filtro", "theit0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asusername", is("theit0")));
    }

}
