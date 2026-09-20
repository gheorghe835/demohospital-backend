package com.hospital.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Table(name = "admissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_cnp", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private User doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_id")
    private Bed bed;

    @Column(name = "admission_date", nullable = false)
    private LocalDateTime admissionDate;

    @Column(length = 500)
    private String reason;

    @Column(columnDefinition = "TEXT")
    private String symptoms;

    @Enumerated(EnumType.STRING)
    @Column(name = "triage_level", nullable = false, length = 20)
    private TriageLevel triageLevel;

    @Column(name = "triage_score")
    private Integer triageScore;

    @Column(columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "treatment_plan", columnDefinition = "TEXT")
    private String treatmentPlan;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "discharge_date")
    private LocalDateTime dischargeDate;

    @Column(name = "discharge_summary", columnDefinition = "TEXT")
    private String dischargeSummary;

    @PrePersist
    protected void onCreate() {
        if (this.admissionDate == null) {
            this.admissionDate = LocalDateTime.now();
        }
    }
}
