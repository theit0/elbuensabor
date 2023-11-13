package elbuensabor.services;

import elbuensabor.DTO.ArticuloManufacturadoDTO;
import elbuensabor.entities.ArticuloManufacturado;
import elbuensabor.repositories.ArticuloManufacturadoRepository;
import elbuensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService {
    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
    }

    @Override
    public List<ArticuloManufacturado> busquedaPorAlta() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.busquedaPorAlta();
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturado> busquedaPorDenominacion(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.busquedaPorDenominacion(filtro);
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturado> filtradoPorPrecioDesc() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.filtradoPorPrecioDesc();
            return articuloManufacturados;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturado> filtradoPorPrecioAsc() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.filtradoPorPrecioAsc();
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<ArticuloManufacturadoDTO> filtradoPorProductoVendido() throws Exception {
        try {
            List<ArticuloManufacturadoDTO> productos = articuloManufacturadoRepository.filtroPorProductoVendido();
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturadoDTO> filtradoPorProductoVendidoPorFecha(Date filtro1, Date filtro2) throws Exception {
        try {
            List<ArticuloManufacturadoDTO> productos = articuloManufacturadoRepository.filtradoPorProductoVendidoPorFecha(filtro1,filtro2);
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}