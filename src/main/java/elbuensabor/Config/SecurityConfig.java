package elbuensabor.Config;

import elbuensabor.jwt.JwtAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        .requestMatchers("/auth/login").permitAll()
                                        .requestMatchers("/auth/register").permitAll()
                                        .requestMatchers("/auth/registerEmpleado").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("/auth/loginEmpleado").permitAll()
                                        .requestMatchers(HttpMethod.PUT,"/api/v1/clientes/{id}").hasAuthority("CLIENTE")
                                        .requestMatchers("/api/v1/clientes/**").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("/api/v1/ArticuloManufacturado/**").permitAll()
                                        .requestMatchers(HttpMethod.GET,"/api/v1/ArticuloManufacturado").permitAll()
                                        .requestMatchers("/api/v1/ArticuloManufacturado/filtradoPorPrecioAsc").permitAll()
                                        .requestMatchers("/api/v1/ArticuloManufacturado/filtradoPorPrecioDesc").permitAll()
                                        .requestMatchers("/api/v1/ArticuloManufacturado/busquedaPorDenominacionA").permitAll()
                                        .requestMatchers(HttpMethod.POST,"/api/v1/pedidos").hasAuthority("CLIENTE")
                                        .requestMatchers("/api/v1/pedidos/busquedaPorEstado").hasAuthority("EMPLEADO")
                                        .requestMatchers("/api/v1/pedidos/buscarPedidoEnDelivery").hasAuthority("EMPLEADO")
                                        .requestMatchers("/api/v1/pedidos//busquedaPedidosAConfirmar").hasAuthority("EMPLEADO")
                                        .requestMatchers("/api/v1/factura/Facturar").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers(HttpMethod.POST,"/api/v1/rubros").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")
                                        .requestMatchers(HttpMethod.DELETE,"/api/v1/rubros/{id}").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")
                                        .requestMatchers(HttpMethod.PUT,"/api/v1/rubros/{id}").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")

                                        .requestMatchers(HttpMethod.POST,"/api/v1/ArticuloManufacturado").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")
                                        .requestMatchers(HttpMethod.DELETE,"/api/v1/ArticuloManufacturado/{id}").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")
                                        .requestMatchers(HttpMethod.PUT,"/api/v1/ArticuloManufacturado/{id}").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")
                                        .requestMatchers(HttpMethod.PUT,"/api/v1/ArticuloInsumo/{id}").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")
                                        .requestMatchers("/api/v1/ArticuloInsumo/mostrarArticulosBajosDeStock").hasAnyAuthority("ADMINISTRADOR","EMPLEADO")
                                        .requestMatchers("api/v1/pedidos/rankingProductos").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("api/v1/pedidos/rankingProductosPorFecha").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("api/v1/clientes/filtradoPorPedidos").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("api/v1/clientes/filtradoPorImporte").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("api/v1/clientes/filtradoPorPedidosFecha").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("api/v1/clientes/filtradoPorImporteFecha").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("api/v1/pedidos/MovimientosMonetarios").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers("api/v1/pedidos/MovimientosMonetariosFecha").hasAuthority("ADMINISTRADOR")
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()


                                        //.anyRequest().authenticated
                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager-> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }

}