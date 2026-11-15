package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.StaffAssignment;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class InFileStaffAssignmentRepository extends InFileBaseRepository<StaffAssignment> {
    public InFileStaffAssignmentRepository(@Value("${repository.staffAssignment.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId(StaffAssignment staffAssignment) {
        return staffAssignment.getId();
    }

    @Override
    protected TypeReference<List<StaffAssignment>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
