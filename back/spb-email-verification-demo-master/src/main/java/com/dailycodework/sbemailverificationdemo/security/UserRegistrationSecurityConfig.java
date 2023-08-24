package com.dailycodework.sbemailverificationdemo.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class UserRegistrationSecurityConfig {
	
//	private final JwtFilter jwtFilter;
//	UsernamePasswordAuthenticationFilter u = new UsernamePasswordAuthenticationFilter();
//	
//	@Autowired
//    public UserRegistrationSecurityConfig(JwtFilter jwtFilter) {
//        this.jwtFilter = jwtFilter;
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
            .cors()
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeHttpRequests()
            
            		.requestMatchers("/**").permitAll();//FUNCIONANDO

//                    .requestMatchers("/users/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                    
//                    .requestMatchers(HttpMethod.GET, "/api/pizzas/**").hasAnyRole("ADMIN", "CUSTOMER")
//                    .requestMatchers(HttpMethod.POST, "/api/pizzas/**").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
//                    .requestMatchers("/api/orders/random").hasAuthority("random_order")
//                    .requestMatchers("/api/orders/**").hasRole("ADMIN")
                    
                    
            
             // Agregar la configuración para el logout
             // URL que activa el logout
            // Eliminar las cookies necesarias y redirigir al inicio de sesión después del logout
            
             // Redirige a una URL específica después del logout exitoso
        return http.build();
        
    }
    
        
        

}
