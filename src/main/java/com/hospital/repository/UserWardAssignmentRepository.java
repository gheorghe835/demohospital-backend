package com.hospital.repository;

import com.hospital.domain.AssignmentType;
import com.hospital.domain.UserWardAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserWardAssignmentRepository extends JpaRepository<UserWardAssignment, Long> {

    List<UserWardAssignment> findByUserIdAndIsActiveTrue(Long userId);

    List<UserWardAssignment> findByWardIdAndIsActiveTrue(Long wardId);

    List<UserWardAssignment> findByWardIdAndAssignmentTypeAndIsActiveTrue(
            Long wardId, AssignmentType assignmentType);

    boolean existsByUserIdAndWardIdAndIsActiveTrue(Long userId, Long wardId);

    Optional<UserWardAssignment> findByUserIdAndWardIdAndIsActiveTrue(
            Long userId, Long wardId);
}
