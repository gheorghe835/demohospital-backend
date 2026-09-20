package com.hospital.repository;

import com.hospital.domain.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {

    List<Shift> findByUserIdAndShiftDate(Long userId, LocalDate shiftDate);

    List<Shift> findByWardIdAndShiftDate(Long wardId, LocalDate shiftDate);

    List<Shift> findByShiftDate(LocalDate shiftDate);

    List<Shift> findByUserId(Long userId);

    List<Shift> findByWardIdAndIsActiveTrue(Long wardId);
}
