package com.hospital.repository;

import com.hospital.domain.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {

    Optional<Ward> findByCode(String code);

    List<Ward> findByIsActiveTrue();

    boolean existsByCode(String code);
}
