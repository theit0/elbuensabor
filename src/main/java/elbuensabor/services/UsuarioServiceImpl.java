package elbuensabor.services;

import DTO.ClientePorImporteDTO;
import elbuensabor.entities.Usuario;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.ClienteRepository;
import elbuensabor.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Usuario> buscarUsuarioPorUserName(String filtro) throws Exception {
        try {
            List<Usuario> usuarios = usuarioRepository.buscarUsuarioPorUserName(filtro);
            return usuarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
