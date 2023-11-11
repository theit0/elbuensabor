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
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        .requestMatchers("/auth/login").permitAll()
                                        .requestMatchers("/auth/register").permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/MovimientosMonetarios")).permitAll()
                                        //.requestMatchers("/auth/registerAdmin").permitAll()
                                        //.requestMatchers("/auth/registerEmpleado").hasAuthority("ADMIN")
                                        //.requestMatchers("/auth/loginEmpleado").permitAll()
                                        //.requestMatchers(HttpMethod.PUT,"/api/v1/clientes/{id}").hasAuthority("CLI")
                                        //.requestMatchers(HttpMethod.GET,"/api/v1/clientes/").hasAuthority("ADMIN")
                                      //  .requestMatchers("/api/v1/ArticuloManufacturado/**").permitAll()
                                       // .requestMatchers(HttpMethod.GET,"/api/v1/ArticuloManufacturado").permitAll()
                                       // .requestMatchers(new AntPathRequestMatcher("/api/v1/ArticuloManufacturado/filtradoPorPrecioDesc")).authenticated()//.hasAuthority("CLI")                                        .requestMatchers("/api/v1/ArticuloManufacturado/filtradoPorPrecioAsc").permitAll()
                                       // .requestMatchers("/api/v1/ArticuloManufacturado/filtradoPorPrecioDesc").permitAll()
                                        //.requestMatchers("/api/v1/ArticuloManufacturado/busquedaPorDenominacionA").permitAll()
                                        //.requestMatchers(HttpMethod.POST,"/api/v1/pedidos").hasAuthority("CLI")
                                        //.requestMatchers("/api/v1/pedidos/busquedaPorEstado").hasAuthority("EMP")
                                        //.requestMatchers("/api/v1/pedidos/buscarPedidoEnDelivery").hasAuthority("EMP")
                                        //.requestMatchers("/api/v1/pedidos//busquedaPedidosAConfirmar").hasAuthority("EMP")
                                        //.requestMatchers("/api/v1/factura/Facturar").hasAuthority("ADMIN")
                                        //.requestMatchers(HttpMethod.POST,"/api/v1/rubros").hasAnyAuthority("ADMIN","EMP")
                                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/rubros/{id}").hasAnyAuthority("ADMIN","EMP")
                                        //.requestMatchers(HttpMethod.PUT,"/api/v1/rubros/{id}").hasAnyAuthority("ADMIN","EMP")

                                        //.requestMatchers(HttpMethod.POST,"/api/v1/ArticuloManufacturado").hasAnyAuthority("ADMIN","EMP")
                                        //.requestMatchers(HttpMethod.DELETE,"/api/v1/ArticuloManufacturado/{id}").hasAnyAuthority("ADMIN","EMP")
                                        //.requestMatchers(HttpMethod.PUT,"/api/v1/ArticuloManufacturado/{id}").hasAnyAuthority("ADMIN","EMP")
                                        //.requestMatchers(HttpMethod.PUT,"/api/v1/ArticuloInsumo/{id}").hasAnyAuthority("ADMIN","EMP")
                                        //.requestMatchers("/api/v1/ArticuloInsumo/mostrarArticulosBajosDeStock").hasAnyAuthority("ADMIN","EMP")
                                        //.requestMatchers("api/v1/pedidos/rankingProductos").hasAuthority("ADMIN")
                                        //.requestMatchers("api/v1/pedidos/rankingProductosPorFecha").hasAuthority("ADMIN")
                                        //.requestMatchers("api/v1/clientes/filtradoPorPedidos").hasAuthority("ADMIN")
                                        //.requestMatchers("api/v1/clientes/filtradoPorImporte").hasAuthority("ADMIN")
                                        //.requestMatchers("api/v1/clientes/filtradoPorPedidosFecha").hasAuthority("ADMIN")
                                        //.requestMatchers("api/v1/clientes/filtradoPorImporteFecha").hasAuthority("ADMIN")
                                        //.requestMatchers("api/v1/pedidos/MovimientosMonetarios").hasAuthority("ADMIN")
                                        //.requestMatchers("api/v1/pedidos/MovimientosMonetariosFecha").hasAuthority("ADMIN")
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