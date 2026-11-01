package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.SecurityStaff;
import org.springframework.stereotype.Repository;

@Repository
public class InMemorySecurityStaffRepository extends InMemoryBaseRepository<SecurityStaff> implements SecurityStaffRepository {
    @Override
    protected String extractId(SecurityStaff entity) {
        return entity.getId();
    }
}
