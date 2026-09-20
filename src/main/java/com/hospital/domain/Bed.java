package com.hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "beds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bed_number", nullable = false, length = 20)
    private String bedNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    @Column(name = "is_occupied", nullable = false)
    private Boolean isOccupied = false;

    @Column(name = "is_reserved", nullable = false)
    private Boolean isReserved = false;

    @Column(name = "occupied_since")
    private LocalDateTime occupiedSince;
}
