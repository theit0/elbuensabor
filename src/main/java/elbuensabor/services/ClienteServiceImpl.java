package elbuensabor.services;

import elbuensabor.DTO.ClienteDTO;
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

    @Override
    public List<ClienteDTO> filtradoPorPedidos() throws Exception {
        try {
            List<ClienteDTO> clientes = clienteRepository.filtroPorPedidos();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}