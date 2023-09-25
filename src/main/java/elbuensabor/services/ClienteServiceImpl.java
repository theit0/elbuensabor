package elbuensabor.services;

import elbuensabor.entities.Cliente;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }
}
