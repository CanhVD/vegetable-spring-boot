package com.example.vegetable_shop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private static final String REALM_ACCESS_CLAIM = "realm_access";
    private static final String ROLES_CLAIM = "roles";
    private static final String RESOURCE_ACCESS = "resource_access";
    private static final String APP_NAME = "vegetable_shop";

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/actuator/**").permitAll()
                        .anyRequest().permitAll())
                .cors(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));

        return http.build();
    }

    /// decode token o day https://jwt.io/
    @SuppressWarnings("unchecked")
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Set<String> mappedAuthorities = new HashSet<>();

            if (jwt.hasClaim(REALM_ACCESS_CLAIM)) {
                List<String> roles = (List<String>) jwt.getClaimAsMap(REALM_ACCESS_CLAIM).get(ROLES_CLAIM);
                mappedAuthorities.addAll(roles);
            }

            if (jwt.hasClaim(RESOURCE_ACCESS)) {
                Map<String, Object> resourceAccess = jwt.getClaimAsMap(RESOURCE_ACCESS);

                if (resourceAccess.get(APP_NAME) != null) {
                    Map<String, Object> appName =
                            (Map<String, Object>) resourceAccess.get(APP_NAME);

                    List<String> roles =
                            (List<String>) appName.get(ROLES_CLAIM);

                    mappedAuthorities.addAll(roles);
                }
            }

            // scope client
            List<String> scopes = Arrays.stream(jwt.getClaimAsString("scope").split("\\s+")).map(scope -> "SCOPE_" + scope).toList();

            mappedAuthorities.addAll(scopes);
            // make authorities
            return mappedAuthorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        });

        return converter;
    }
}