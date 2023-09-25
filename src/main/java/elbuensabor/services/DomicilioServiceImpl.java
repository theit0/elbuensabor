package elbuensabor.services;

import elbuensabor.entities.Domicilio;
import elbuensabor.entities.Usuario;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.DomicilioRepository;
import elbuensabor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio,Long> implements DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }
}
