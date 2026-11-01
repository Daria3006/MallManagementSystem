package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.StaffAssignment;

public class InMemoryStaffAssignmentRepository extends InMemoryBaseRepository<StaffAssignment> implements StaffAssignmentRepository {
    @Override
    protected String extractId(StaffAssignment entity) {
        return entity.getId();
    }
}
