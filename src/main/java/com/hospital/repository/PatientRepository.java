package com.hospital.repository;

import com.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

    boolean existsByCnp(String cnp);

    List<Patient> findByLastNameContainingIgnoreCase(String lastName);

    List<Patient> findByFirstNameContainingIgnoreCase(String firstName);

    List<Patient> findByParentPhone(String parentPhone);
}
