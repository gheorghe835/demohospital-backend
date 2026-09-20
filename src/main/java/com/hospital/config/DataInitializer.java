package com.hospital.config;

import com.hospital.domain.Role;
import com.hospital.domain.User;
import com.hospital.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UserRepository userRepository,
                               PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                User admin = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .fullName("Administrator General")
                        .email("admin@hospital.md")
                        .phone("069000000")
                        .role(Role.SUPER_ADMIN)
                        .isActive(true)
                        .build();
                userRepository.save(admin);
                System.out.println(">>> User demo creat: admin / admin123");
            }
        };
    }
}
