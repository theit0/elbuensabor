package elbuensabor.services;

import elbuensabor.entities.Usuario;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario,Long>{


    List<Usuario> buscarUsuarioPorUserName(String filtro) throws Exception;
}
