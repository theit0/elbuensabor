package elbuensabor.services;

import elbuensabor.entities.Factura;

public interface FacturaService extends BaseService<Factura,Long>{
  void FacturarPedido(Long id) throws Exception;
}
