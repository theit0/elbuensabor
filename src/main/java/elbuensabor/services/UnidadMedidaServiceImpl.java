package elbuensabor.services;

import elbuensabor.entities.UnidadMedida;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida,Long> implements UnidadMedidaService {
    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;
    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida,Long>baseRepository,UnidadMedidaRepository unidadMedidaRepository){
        super(baseRepository);
    }
}
