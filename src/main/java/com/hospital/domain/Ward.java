package com.hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    @Column(length = 20)
    private String phone;

    @Column(name = "total_beds", nullable = false)
    private Integer totalBeds;

    @Column(length = 255)
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
