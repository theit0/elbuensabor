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
			RubroArticulo bebidasinalcohol1 = RubroArticulo.builder()
					.denominacion("Bebidas sin alcohol")
					.fechaAlta(LocalDateTime.now())
					//.rubroPadre(bebidas)
					.build();
			rubroArticuloRepository.save(bebidasinalcohol1);
			RubroArticulo bebidaconalcohol1 = RubroArticulo.builder()
					.denominacion("Bebidas con alcohol")
					.fechaAlta(LocalDateTime.now())
					//.rubroPadre(bebidas)
					.build();
			rubroArticuloRepository.save(bebidaconalcohol1);


			ArticuloManufacturado Fanta = ArticuloManufacturado.builder()
					.denominacion("Fanta 500ml")
					.costo(new BigDecimal(500))
					.precioVenta(new BigDecimal(800))
					.urlImagen("https://i.ibb.co/2h4WF2r/pngwing-com-3-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)
					.build();
			articuloManufacturadoRepository.save(Fanta);
			ArticuloManufacturado Sprite = ArticuloManufacturado.builder()
					.denominacion("Sprite 500ml")
					.costo(new BigDecimal(500))
					.precioVenta(new BigDecimal(800))
					.urlImagen("https://i.ibb.co/z75JBp3/pngwing-com-4-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)

					.build();
			articuloManufacturadoRepository.save(Sprite);
			ArticuloManufacturado Cerveza = ArticuloManufacturado.builder()
					.denominacion("Cerveza Heineken")
					.costo(new BigDecimal(700))
					.precioVenta(new BigDecimal(1000))
					.urlImagen("https://i.ibb.co/0Jwv8dT/pngwing-com-11-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidaconalcohol1)
					.build();
			articuloManufacturadoRepository.save(Cerveza);
			ArticuloManufacturado Hamburguesa = ArticuloManufacturado.builder()
					.costo(new BigDecimal(1000))
					.denominacion("Hamburguesa Completa")
					.descripcion("Hamburguesa una carne, verduras, y queso.  Ideal para 1 persona")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(2000))
					.tiempoEstimadoCocina(50)
					.urlImagen("https://i.ibb.co/2tV7KPm/pngwing-com-25.webp")
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
					.denominacion("Empanada de carne")
					.descripcion("6 empanadas. Ideal para 1 persona")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1600))
					.tiempoEstimadoCocina(20)
					.urlImagen("https://i.ibb.co/yWCnPDX/pngwing-com-13.png")
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(EmpanadasCarne);
			ArticuloManufacturado EmpanadasJamon = ArticuloManufacturado.builder()
					.costo(new BigDecimal(800))
					.denominacion("Empanada de Jamon y queso")
					.descripcion("6 empanadas. Ideal para 1 persona")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1600))
					.tiempoEstimadoCocina(15)
					.urlImagen("https://i.ibb.co/yWCnPDX/pngwing-com-13.png")
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(EmpanadasJamon);






			ArticuloManufacturado HotDog = ArticuloManufacturado.builder()
					.denominacion("Hot Dog Clásico")
					.descripcion("Deliciosa salchicha en pan con aderezos clásicos. Ideal para una persona.")
					.costo(new BigDecimal(300))
					.precioVenta(new BigDecimal(500))
					.urlImagen("https://i.ibb.co/GQzpp9Y/pngwing-com-15.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(HotDog);

			ArticuloManufacturado PapasFritas = ArticuloManufacturado.builder()
					.denominacion("Papas Fritas Crispy")
					.descripcion("Crujientes papas fritas con la mezcla perfecta de especias. Ideal para compartir.")
					.costo(new BigDecimal(200))
					.precioVenta(new BigDecimal(400))
					.urlImagen("https://i.ibb.co/HgdGxsX/pngwing-com-16.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(PapasFritas);

			ArticuloManufacturado NuggetsPollo = ArticuloManufacturado.builder()
					.denominacion("Nuggets de Pollo")
					.descripcion("Trozos jugosos de pollo empanizados. Perfectos para picar.")
					.costo(new BigDecimal(400))
					.precioVenta(new BigDecimal(700))
					.urlImagen("https://i.ibb.co/37mHffp/pngwing-com-17.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(NuggetsPollo);

			ArticuloManufacturado EnsaladaCesar = ArticuloManufacturado.builder()
					.denominacion("Ensalada César")
					.descripcion("Ensalada fresca con pollo, crutones y aderezo César. Una opción saludable y deliciosa.")
					.costo(new BigDecimal(350))
					.precioVenta(new BigDecimal(600))
					.urlImagen("https://i.ibb.co/RjgwBm3/pngwing-com-18.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(EnsaladaCesar);


			ArticuloManufacturado SushiVariado = ArticuloManufacturado.builder()
					.denominacion("Sushi Variado")
					.descripcion("Variedad de sushi fresco y delicioso. Una experiencia culinaria única.")
					.costo(new BigDecimal(600))
					.precioVenta(new BigDecimal(1000))
					.urlImagen("https://i.ibb.co/Ph8vryj/pngwing-com-19.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(SushiVariado);

			ArticuloManufacturado Burrito = ArticuloManufacturado.builder()
					.denominacion("Burrito Mexicano")
					.descripcion("Sabroso burrito con carne, arroz, frijoles y salsa. Una explosión de sabores mexicanos.")
					.costo(new BigDecimal(500))
					.precioVenta(new BigDecimal(900))
					.urlImagen("https://i.ibb.co/XWT9nqC/pngwing-com-23.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(Burrito);

			ArticuloManufacturado Donuts = ArticuloManufacturado.builder()
					.denominacion("Donuts Glaseados")
					.descripcion("Donuts esponjosos y glaseados en varios sabores. Un dulce placer para cualquier momento.")
					.costo(new BigDecimal(250))
					.precioVenta(new BigDecimal(450))
					.urlImagen("https://i.ibb.co/GTj860n/pngwing-com-20.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(Donuts);

			ArticuloManufacturado Tiramisu = ArticuloManufacturado.builder()
					.denominacion("Tiramisú Italiano")
					.descripcion("Postre italiano clásico con capas de café y crema mascarpone. Irresistiblemente delicioso.")
					.costo(new BigDecimal(350))
					.precioVenta(new BigDecimal(600))
					.urlImagen("https://i.ibb.co/8cXjY3T/pngwing-com-21.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(Tiramisu);

			ArticuloManufacturado WrapVegetariano = ArticuloManufacturado.builder()
					.denominacion("Wrap Vegetariano")
					.descripcion("Wrap saludable con una mezcla de verduras frescas y aderezo ligero. Perfecto para vegetarianos.")
					.costo(new BigDecimal(400))
					.precioVenta(new BigDecimal(700))
					.urlImagen("https://i.ibb.co/0Y36Zyp/pngwing-com-22.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(WrapVegetariano);

			ArticuloManufacturado Milanesa = ArticuloManufacturado.builder()
					.denominacion("Milanesa de Pollo")
					.descripcion("Jugosa milanesa de pollo empanizada, acompañada de papas fritas. ¡Una delicia clásica!")
					.costo(new BigDecimal(350))
					.precioVenta(new BigDecimal(600))
					.urlImagen("https://i.ibb.co/TYY8Y0g/pngwing-com-24.webp")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(ComidaRapida)
					.build();
			articuloManufacturadoRepository.save(Milanesa);











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

			Factura factura1 = Factura.builder()
					.fechaAlta(LocalDateTime.now())
					.fechaFacturacion(LocalDateTime.now())
					.formaPago(FormaPago.EFECTIVO)
					.pedido(pedido1)
					.build();
			facturaRepository.save(factura1);

		};
	}
}