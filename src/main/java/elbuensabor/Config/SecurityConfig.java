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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception
    {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/auth/registerAdmin")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/auth/register")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/auth/registerEmpleado")).authenticated()
                                        .requestMatchers(new AntPathRequestMatcher("/auth/loginEmpleado")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/clientes/{id}")).hasAuthority("CLI")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/clientes")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado/filtradoPorPrecioDesc")).hasAuthority("CLI")                                        .requestMatchers("/api/v1/ArticuloManufacturado/filtradoPorPrecioAsc").permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado/filtradoPorPrecioDesc")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado/busquedaPorDenominacionA")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos")).hasAuthority("CLI")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/busquedaPorEstado")).hasAuthority("EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/buscarPedidoEnDelivery")).hasAuthority("EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos//busquedaPedidosAConfirmar")).hasAuthority("EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/factura/Facturar")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubros")).hasAnyAuthority("ADMIN","EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubros/{id}")).hasAnyAuthority("ADMIN","EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubros/{id}")).hasAnyAuthority("ADMIN","EMP")

                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado")).hasAnyAuthority("ADMIN","EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado/{id}")).hasAnyAuthority("ADMIN","EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado/{id}")).hasAnyAuthority("ADMIN","EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloInsumo/{id}")).hasAnyAuthority("ADMIN","EMP")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloInsumo/mostrarArticulosBajosDeStock")).hasAnyAuthority("ADMIN","EMP")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/pedidos/rankingProductos")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/pedidos/rankingProductosPorFecha")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/clientes/filtradoPorPedidos")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/clientes/filtradoPorImporte")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/clientes/filtradoPorPedidosFecha")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/clientes/filtradoPorImporteFecha")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/pedidos/MovimientosMonetarios")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("api/v1/pedidos/MovimientosMonetariosFecha")).hasAuthority("ADMIN")
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager-> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();





    }

}