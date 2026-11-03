package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.StaffAssignment;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStaffAssignmentRepository extends InMemoryBaseRepository<StaffAssignment>{
    @Override
    protected String extractId(StaffAssignment entity) {
        return entity.getId();
    }
}
