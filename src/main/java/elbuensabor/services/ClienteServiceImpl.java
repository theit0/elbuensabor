package elbuensabor.services;

import elbuensabor.DTO.ClienteDTO;
import elbuensabor.DTO.ClientePorImporteDTO;
import elbuensabor.entities.Cliente;
import elbuensabor.repositories.BaseRepository;
import elbuensabor.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Transactional
    public List<ClienteDTO> filtradoPorPedidos() throws Exception {
        try {
            List<ClienteDTO> clientes = clienteRepository.filtroPorPedidos();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<ClientePorImporteDTO> filtradoPorImporte() throws Exception {
        try {
            List<ClientePorImporteDTO> clientes = clienteRepository.filtroPorImporte();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @SneakyThrows
    @Override
    @Transactional
    public List<ClienteDTO> filtroPorPedidosFecha(Date filtro1, Date filtro2) {
        try {
            List<ClienteDTO> clientes = clienteRepository.filtroPorPedidosFecha(filtro1, filtro2);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<ClientePorImporteDTO> filtradoPorImporteFechas(Date filtro1, Date filtro2) throws Exception {
        try {
            List<ClientePorImporteDTO> clientes = clienteRepository.filtroPorImporteFechas(filtro1, filtro2);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Cliente> BuscarPorNyA(String filtro) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.BuscarPorNyA(filtro);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}