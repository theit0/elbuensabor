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
			RubroArticulo ComidaRapida = RubroArticulo.builder()
					.denominacion("Comida Rapida")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(ComidaRapida);
			RubroArticulo ComidaSana = RubroArticulo.builder()
					.denominacion("Comida Sana")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(ComidaSana);
			RubroArticulo bebidas = RubroArticulo.builder()
					.denominacion("bebidas")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(bebidas);
			RubroArticulo bebidasinalcohol1 = RubroArticulo.builder()
					.denominacion("bebidas sin alcohol")
					.fechaAlta(LocalDateTime.now())
					//.rubroPadre(bebidas)
					.build();
			rubroArticuloRepository.save(bebidasinalcohol1);
			RubroArticulo bebidaconalcohol1 = RubroArticulo.builder()
					.denominacion("bebidas con alcohol")
					.fechaAlta(LocalDateTime.now())
					//.rubroPadre(bebidas)
					.build();
			rubroArticuloRepository.save(bebidaconalcohol1);

			ArticuloInsumo Cocacola = ArticuloInsumo.builder()
					.denominacion("Cocacola 500ml")
					.precioCompra(new BigDecimal(599.99))
					.stockActual(new BigDecimal(100))
					.stockMinimo(new BigDecimal(10))
					.urlImagen("https://i.ibb.co/nDjVtXX/pngwing-com-2-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)
					.unidadMedida(mililitros)
					.build();
			articuloInsumoRepository.save(Cocacola);
			ArticuloInsumo Fanta = ArticuloInsumo.builder()
					.denominacion("Fanta 500ml")
					.precioCompra(new BigDecimal(599.99))
					.stockActual(new BigDecimal(80))
					.stockMinimo(new BigDecimal(10))
					.urlImagen("https://i.ibb.co/2h4WF2r/pngwing-com-3-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)
					.unidadMedida(mililitros)
					.build();
			articuloInsumoRepository.save(Fanta);
			ArticuloInsumo Sprite = ArticuloInsumo.builder()
					.denominacion("Sprite 500ml")
					.precioCompra(new BigDecimal(599.99))
					.stockActual(new BigDecimal(59))
					.stockMinimo(new BigDecimal(10))
					.urlImagen("https://i.ibb.co/z75JBp3/pngwing-com-4-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)
					.unidadMedida(mililitros)
					.build();
			articuloInsumoRepository.save(Sprite);
			ArticuloInsumo Cerveza = ArticuloInsumo.builder()
					.denominacion("Cerveza Heineken")
					.precioCompra(new BigDecimal(899.99))
					.stockActual(new BigDecimal(34))
					.stockMinimo(new BigDecimal(5))
					.urlImagen("https://i.ibb.co/0Jwv8dT/pngwing-com-11-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidaconalcohol1)
					.unidadMedida(mililitros)
					.build();
			articuloInsumoRepository.save(Cerveza);
			ArticuloManufacturado Hamburguesa = ArticuloManufacturado.builder()
					.costo(new BigDecimal(1000))
					.denominacion("Hamburguesa Completa")
					.descripcion("Hamburguesa una carne, verduras, y queso.  Ideal para 1 persona")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(2000))
					.tiempoEstimadoCocina(50)
					.urlImagen("https://i.ibb.co/Srv0rhf/pngwing-com-5-1.png")
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(Hamburguesa);
			ArticuloManufacturado Taco = ArticuloManufacturado.builder()
					.costo(new BigDecimal(500))
					.denominacion("Taco Mexicano")
					.descripcion("Taco azteca con mucho picante.  Ideal para 1 persona")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1000))
					.tiempoEstimadoCocina(30)
					.urlImagen("https://i.ibb.co/grXmj7F/pngwing-com-7-1.png")
					.rubroArticulo(ComidaSana)
					.build();

			articuloManufacturadoRepository.save(Taco);
			ArticuloManufacturado Lomo = ArticuloManufacturado.builder()
					.costo(new BigDecimal(1000))
					.denominacion("Lomo completo de carne")
					.descripcion("trae huevo, queso, jamon. Ideal para 2 personas")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(2000))
					.tiempoEstimadoCocina(40)
					.urlImagen("https://i.ibb.co/gSjM1PY/pngwing-com-6-1.png")
					.rubroArticulo(ComidaSana)
					.build();
			articuloManufacturadoRepository.save(Lomo);
			ArticuloManufacturado PizzaMuzza = ArticuloManufacturado.builder()
					.costo(new BigDecimal(750))
					.denominacion("Pizza muzzarela")
					.descripcion("8 poriones. Ideal para 2 personas")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1500))
					.tiempoEstimadoCocina(10)
					.urlImagen("https://i.ibb.co/rc88348/pngwing-com-8-1.png")
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(PizzaMuzza);
			ArticuloManufacturado PizzaEspe = ArticuloManufacturado.builder()
					.costo(new BigDecimal(750))
					.denominacion("Pizza Peperoni")
					.descripcion("8 poriones. Ideal para 2 personas")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1500))
					.tiempoEstimadoCocina(10)
					.urlImagen("https://i.ibb.co/ZG3YR0k/pngwing-com-9-1.png")
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(PizzaEspe);
			ArticuloManufacturado EmpanadasCarne = ArticuloManufacturado.builder()
					.costo(new BigDecimal(800))
					.denominacion("6 empanadas de carne")
					.descripcion("6 empanadas. Ideal para 1 persona")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1600))
					.tiempoEstimadoCocina(20)
					.urlImagen("https://i.ibb.co/ZgL0xZg/pngwing-com-10-1.png")
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(EmpanadasCarne);
			ArticuloManufacturado EmpanadasJamon = ArticuloManufacturado.builder()
					.costo(new BigDecimal(800))
					.denominacion("6 empanadas de Jamon y queso")
					.descripcion("6 empanadas. Ideal para 1 persona")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1600))
					.tiempoEstimadoCocina(15)
					.urlImagen("https://i.ibb.co/ZgL0xZg/pngwing-com-10-1.png")
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(EmpanadasJamon);



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