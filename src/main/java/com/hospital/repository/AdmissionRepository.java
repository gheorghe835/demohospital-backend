package com.hospital.repository;

import com.hospital.domain.Admission;
import com.hospital.domain.TriageLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {

    List<Admission> findByIsActiveTrue();

    List<Admission> findByPatientCnp(String cnp);

    List<Admission> findByDoctorId(Long doctorId);

    List<Admission> findByWardIdAndIsActiveTrue(Long wardId);

    Optional<Admission> findByBedIdAndIsActiveTrue(Long bedId);

    long countByIsActiveTrue();

    long countByWardIdAndIsActiveTrue(Long wardId);

    List<Admission> findByTriageLevelAndIsActiveTrue(TriageLevel triageLevel);
}
