package com.hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @Column(length = 13, nullable = false, unique = true)
    private String cnp;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 1)
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_type", length = 20)
    private BloodType bloodType;

    @Column(length = 20)
    private String phone;

    @Column(length = 255)
    private String address;

    @Column(name = "parent_name", nullable = false, length = 100)
    private String parentName;

    @Column(name = "parent_phone", nullable = false, length = 20)
    private String parentPhone;

    @Column(name = "insurance_number", length = 50)
    private String insuranceNumber;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
