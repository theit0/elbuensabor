package elbuensabor.services;

import elbuensabor.entities.Usuario;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
    }
}
