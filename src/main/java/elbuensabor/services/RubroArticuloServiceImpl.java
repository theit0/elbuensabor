package elbuensabor.services;

import elbuensabor.entities.RubroArticulo;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo,Long> implements RubroArticuloService{
    @Autowired
    RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo,Long> baseRepository, RubroArticuloRepository rubroArticuloRepository){
        super(baseRepository);
    }
}
