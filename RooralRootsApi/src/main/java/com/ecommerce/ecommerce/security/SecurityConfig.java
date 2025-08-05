package com.ecommerce.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.ecommerce.ecommerce.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth

                // Buyer routes come after seller routes
                // Buyer routes come after seller routes
                // Common routes for both buyer and seller
                // .requestMatchers("/v1/api/user/info", "/v1/api/user/update", "/v1/api/order/saveorupdate",
                //         "/v1/custom-order/saveorupdate")
                // .hasAnyRole("buyer", "seller")

                // // Seller-specific routes
                // .requestMatchers("/v1/api/user/profile", "/v1/api/user/list",
                //         "/v1/api/product/bill", "/v1/api/product/saveorupdate", "/v1/api/product/delete/id/{id}",
                //         "/v1/api/product/list", "/v1/custom-order/list/owner/{ownerId}",
                //         "/v1/api/order/status/id/{id}/{status}","/v1/custom-order/status/id/{id}/{status}",
                //         "/v1/api/product/list/name/{name}")
                // .hasRole("seller")

                // // Buyer-specific routes
                // .requestMatchers("/v1/custom-order/list/buyer/{buyerid}")
                // .hasRole("buyer")

                // Public routes
                .requestMatchers("/v1/api/user/saveorupdate", "/v1/api/user/signin").permitAll()
                .requestMatchers("v1/public/api/product/filter", "/v1/api/categories/list","/v1/public/api/product/filter-latest", "/v1/api/user/id/{id}",
                        "/v1/api/product/id/{id}", "/v1/public/api/product/seller-products/id/{id}")
                .permitAll()

                .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}