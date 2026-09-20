package com.hospital.repository;

import com.hospital.domain.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {

    List<Bed> findByWardIdAndIsOccupiedFalseAndIsReservedFalse(Long wardId);

    List<Bed> findByWardId(Long wardId);

    List<Bed> findByIsOccupiedTrue();

    long countByWardIdAndIsOccupiedFalse(Long wardId);
}
