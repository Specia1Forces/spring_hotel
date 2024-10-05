package com.project.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        //  registry.requestMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN");
        // МОЖНО ТАК




        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    //registry.requestMatchers("/home", "/register/**").permitAll();
                    registry.requestMatchers("/hotel_management").hasAnyRole("MANAGER","ADMIN","HOTEL_MANAGEMENT_SERVICE");
                    registry.requestMatchers("/hotel_management/personnel/**").hasAnyRole("MANAGER","ADMIN");
                    registry.requestMatchers("/hotel_management/room_reservations/**").hasRole("MANAGER");
                    registry.requestMatchers("/hotel_management/clients_and_contracts/**").hasRole("MANAGER");
                    registry.requestMatchers("/all_services").hasAnyRole("MANAGER","ADMIN");
                    registry.requestMatchers(HttpMethod.GET,"/hotel_management/cleaning_and_technical_inspection_log/**").hasAnyRole("MANAGER",

                            "ADMIN","HOTEL_MANAGEMENT_SERVICE");
                    registry.requestMatchers(HttpMethod.POST,"/hotel_management/cleaning_and_technical_inspection_log/**").hasAnyRole("ADMIN",
                            "HOTEL_MANAGEMENT_SERVICE");
                    registry.requestMatchers(HttpMethod.PATCH,"/hotel_management/cleaning_and_technical_inspection_log/**").hasRole("ADMIN");
                    registry.requestMatchers(HttpMethod.DELETE,"/hotel_management/cleaning_and_technical_inspection_log/**").hasRole("ADMIN");

                    registry.anyRequest().authenticated();
                })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }
    //Hotel Management Service
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("manager")
                .password("$2a$12$xOIYYujxAOmczE0MoEjayehbthwwqDKlWGPS9o2BKGZmiKG9cJVg2") //1234
                .roles("MANAGER")
                .build();
        UserDetails adminUser = User.builder()
                .username("admin")
                .password("$2a$12$5QM7j4KXIXId6Nm/81zseOxTIfGFuNHEyRs.tH.RU.VNE11fefEqm") //12345
                .roles("ADMIN")
                .build();

        UserDetails hotelManagementServiceUser = User.builder()
                .username("maids")
                .password("$2a$12$wKrAloN8sKDsM9QdXlH0O.7nUvIC4iQWCMOlgjHPygc26xLBPzLIa") //1111
                .roles("HOTEL_MANAGEMENT_SERVICE")
                .build();
        return new InMemoryUserDetailsManager(normalUser, adminUser,hotelManagementServiceUser);
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}