package elbuensabor;

import elbuensabor.Enumerations.EstadoPedido;
import elbuensabor.Enumerations.FormaPago;
import elbuensabor.Enumerations.TipoEnvio;
import elbuensabor.entities.*;
import elbuensabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static elbuensabor.Enumerations.Rol.*;

@SpringBootApplication(exclude = {SecurityFilterAutoConfiguration.class})
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
					.denominacion("Mililitros")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(mililitros);

			UnidadMedida gramos = UnidadMedida.builder()
					.abreviatura("gr")
					.denominacion("Gramos")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(gramos);

			UnidadMedida unidades = UnidadMedida.builder()
					.abreviatura("unidad")
					.denominacion("Unidades")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(unidades);

			UnidadMedida litros = UnidadMedida.builder()
					.abreviatura("l")
					.denominacion("Litros")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(litros);

			UnidadMedida kilogramos = UnidadMedida.builder()
					.abreviatura("kg")
					.denominacion("Kilogramos")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(kilogramos);
			UnidadMedida unidadDocena = UnidadMedida.builder()
					.abreviatura("docena")
					.denominacion("Docena")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(unidadDocena);

			RubroArticulo comidaRapida = RubroArticulo.builder()
					.denominacion("Comida Rapida")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(comidaRapida);

			RubroArticulo Vegetales = RubroArticulo.builder()
					.denominacion("Vegetales")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(Vegetales);

			RubroArticulo bebidas = RubroArticulo.builder()
					.denominacion("Bebidas")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(bebidas);

			ArticuloInsumo articulo1 = ArticuloInsumo.builder()
					.denominacion("Pan")
					.fechaAlta(LocalDateTime.now())
					.precioCompra(BigDecimal.valueOf(60))
					.stockActual(BigDecimal.valueOf(100))
					.stockMinimo(BigDecimal.valueOf(50))
					.urlImagen("https://t2.uc.ltmcdn.com/es/posts/8/3/6/como_hacer_pan_de_hamburguesa_32638_600.jpg")
					.rubroArticulo(comidaRapida)
					.unidadMedida(unidades)
					.build();
			articuloInsumoRepository.save(articulo1);

			ArticuloInsumo articulo2 = ArticuloInsumo.builder()
					.denominacion("Queso cheddar")
					.fechaAlta(LocalDateTime.now())
					.precioCompra(BigDecimal.valueOf(20))
					.stockActual(BigDecimal.valueOf(80))
					.stockMinimo(BigDecimal.valueOf(40))
					.urlImagen("https://http2.mlstatic.com/D_NQ_NP_678367-MLA45862458371_052021-O.webp")
					.rubroArticulo(comidaRapida)
					.unidadMedida(unidades)
					.build();
			articuloInsumoRepository.save(articulo2);

			ArticuloInsumo articulo3 = ArticuloInsumo.builder()
					.denominacion("Lechuga")
					.fechaAlta(LocalDateTime.now())
					.precioCompra(BigDecimal.valueOf(40))
					.stockActual(BigDecimal.valueOf(20))
					.stockMinimo(BigDecimal.valueOf(2))
					.urlImagen("https://biotrendies.com/wp-content/uploads/2015/07/lechuga-1200x900.jpg")
					.rubroArticulo(Vegetales)
					.unidadMedida(kilogramos)
					.build();
			articuloInsumoRepository.save(articulo3);




			// Agregar más rubros
			RubroArticulo postres = RubroArticulo.builder()
					.denominacion("Postres")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(postres);

			RubroArticulo bebidasAlcoholicas = RubroArticulo.builder()
					.denominacion("Bebidas Alcohólicas")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(bebidasAlcoholicas);

			ArticuloInsumo harina = ArticuloInsumo.builder()
					.denominacion("Harina")
					.fechaAlta(LocalDateTime.now())
					.precioCompra(BigDecimal.valueOf(30))
					.stockActual(BigDecimal.valueOf(200))
					.stockMinimo(BigDecimal.valueOf(100))
					.urlImagen("https://iili.io/JCvwiNV.png")
					.rubroArticulo(comidaRapida)
					.unidadMedida(kilogramos)
					.build();
			articuloInsumoRepository.save(harina);

			ArticuloInsumo huevo = ArticuloInsumo.builder()
					.denominacion("Huevo")
					.fechaAlta(LocalDateTime.now())
					.precioCompra(BigDecimal.valueOf(5))
					.stockActual(BigDecimal.valueOf(300))
					.stockMinimo(BigDecimal.valueOf(150))
					.urlImagen("https://iili.io/JCvwPAQ.png")
					.rubroArticulo(postres)
					.unidadMedida(unidadDocena)
					.build();
			articuloInsumoRepository.save(huevo);












			RubroArticulo bebidasinalcohol1 = RubroArticulo.builder()
					.denominacion("Bebidas sin alcohol")
					.fechaAlta(LocalDateTime.now())
					.rubroPadre(bebidas)
					.build();
			rubroArticuloRepository.save(bebidasinalcohol1);
			RubroArticulo bebidaconalcohol1 = RubroArticulo.builder()
					.denominacion("Bebidas con alcohol")
					.fechaAlta(LocalDateTime.now())
					.rubroPadre(bebidas)
					.build();
			rubroArticuloRepository.save(bebidaconalcohol1);


			ArticuloManufacturado Fanta = ArticuloManufacturado.builder()
					.denominacion("Fanta 500ml")
					.descripcion("Bebida gasificada")
					.costo(new BigDecimal(500))
					.precioVenta(new BigDecimal(800))
					.urlImagen("https://i.ibb.co/2h4WF2r/pngwing-com-3-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)
					.build();
			articuloManufacturadoRepository.save(Fanta);
			ArticuloManufacturado Sprite = ArticuloManufacturado.builder()
					.denominacion("Sprite 500ml")
					.descripcion("Bebida gasificada")
					.costo(new BigDecimal(500))
					.precioVenta(new BigDecimal(800))
					.urlImagen("https://i.ibb.co/z75JBp3/pngwing-com-4-1.png")
					.fechaAlta(LocalDateTime.now())
					.rubroArticulo(bebidasinalcohol1)

					.build();
			articuloManufacturadoRepository.save(Sprite);
			ArticuloManufacturado Cerveza = ArticuloManufacturado.builder()
					.denominacion("Cerveza Heineken")
					.descripcion("Bebida alcholica gasificada")
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
					.urlImagen("https://i.ibb.co/Srv0rhf/pngwing-com-5-1.png")
					.rubroArticulo(comidaRapida)
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
					.rubroArticulo(comidaRapida)
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
					.rubroArticulo(comidaRapida)
					.build();
			articuloManufacturadoRepository.save(Lomo);
			ArticuloManufacturado PizzaMuzza = ArticuloManufacturado.builder()
					.costo(new BigDecimal(750))
					.denominacion("Pizza muzzarela")
					.descripcion("8 porciones. Ideal para 2 personas")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1500))
					.tiempoEstimadoCocina(10)
					.urlImagen("https://i.ibb.co/rc88348/pngwing-com-8-1.png")
					.rubroArticulo(comidaRapida)
					.build();
			articuloManufacturadoRepository.save(PizzaMuzza);
			ArticuloManufacturado PizzaEspe = ArticuloManufacturado.builder()
					.costo(new BigDecimal(750))
					.denominacion("Pizza Peperoni")
					.descripcion("8 porciones. Ideal para 2 personas")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(1500))
					.tiempoEstimadoCocina(10)
					.urlImagen("https://i.ibb.co/ZG3YR0k/pngwing-com-9-1.png")
					.rubroArticulo(comidaRapida)
					.build();
			articuloManufacturadoRepository.save(PizzaEspe);






			Usuario usuario1 = Usuario.builder()
					.username("giovacirrin")
					.fechaAlta(LocalDateTime.now())
					.rol(ADMIN)
					.password("2206")
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


			Usuario usuario2 = Usuario.builder()
					.username("theoP")
					.fechaAlta(LocalDateTime.now())
					.rol(CLI)
					.build();
			Cliente cliente2 = Cliente.builder()
					.apellido("Pelegrina")
					.email("TheoP@gmail.com")
					.fechaAlta(LocalDateTime.now())
					.nombre("Theo")
					.telefono("2616622682")
					.usuario(usuario2)
					.build();
			clienteRepository.save(cliente2);

		};
	}
}