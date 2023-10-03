package elbuensabor;

import elbuensabor.Enumerations.EstadoPedido;
import elbuensabor.Enumerations.FormaPago;
import elbuensabor.Enumerations.TipoEnvio;
import elbuensabor.entities.*;
import elbuensabor.repositories.*;
import org.aspectj.lang.reflect.UnlockSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class ElbuensaborApplication {

	@Autowired
	RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElbuensaborApplication.class, args);

	}


	@Bean
	CommandLineRunner init(RubroArticuloRepository rubroRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository, ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
		return args -> {
			UnidadMedida mililitros = UnidadMedida.builder()
					.abreviatura("ml")
					.denominacion("Milimetros")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(mililitros);
			RubroArticulo bebidas = RubroArticulo.builder()
					.denominacion("bebidas")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(bebidas);
			RubroArticulo bebidasinalcohol1 = RubroArticulo.builder()
					.denominacion("bebidas sin alcohol")
					.fechaAlta(LocalDateTime.now())
					.rubroPadre(bebidas)
					.build();
			rubroArticuloRepository.save(bebidasinalcohol1);
			ArticuloInsumo Cocacola = ArticuloInsumo.builder()
					.denominacion("Cocacola 500ml")
					.precioCompra(new BigDecimal(599.99))
					.stockActual(new BigDecimal(100))
					.stockMinimo(new BigDecimal(10))
					.urlImagen("http://www.ejemplo.com/ruta")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)
					.unidadMedida(mililitros)
					.build();
			articuloInsumoRepository.save(Cocacola);
			Usuario usuario1 = Usuario.builder()
					.asusername("giovacirrin")
					.auth0_id(1)
					.fechaAlta(LocalDateTime.now())
					.build();
			Cliente cliente1 = Cliente.builder()
					.apellido("Cirrincione")
					.email("giovannicirrincione22@gmail.com")
					.fechaAlta(LocalDateTime.now())
					.nombre("giovanni")
					.telefono("2616622682")
					.usuario(usuario1)
					.build();
			clienteRepository.save(cliente1);
			Domicilio domicilio1 = Domicilio.builder()
					.calle("la pampa")
					.codPostal(5507)
					.fechaAlta(LocalDateTime.now())
					.localidad("Lujan")
					.numero(313)
					.cliente(cliente1)
					.build();
			domicilioRepository.save(domicilio1);
			LocalTime horaEspecifica = LocalTime.of(22, 30, 0);
			Pedido pedido1 = Pedido.builder()
					.cliente(cliente1)
					.domicilioEntrega(domicilio1)
					.estado(EstadoPedido.PAGADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.fechaAlta(LocalDateTime.now())
					.horaEstimadaFinalizacion(horaEspecifica)
					.build();
			pedidoRepository.save(pedido1);
			DetallePedido detalle1 = DetallePedido.builder()
					.cantidad(4)
					.articuloInsumo(Cocacola)
					.pedido(pedido1)
					.build();
			detallePedidoRepository.save(detalle1);
			Factura factura1 = Factura.builder()
					.fechaAlta(LocalDateTime.now())
					.fechaFacturacion(LocalDateTime.now())
					.formaPago(FormaPago.EFECTIVO)
					.pedido(pedido1)
					.build();
			facturaRepository.save(factura1);
			DetalleFactura detallefac1 = DetalleFactura.builder()
					.cantidad(4)
					.articuloInsumo(Cocacola)
					.factura(factura1)
					.build();
			detalleFacturaRepository.save(detallefac1);


		};
	}
}