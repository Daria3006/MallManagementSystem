package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.SecurityStaff;

public class InMemorySecurityStaffRepository extends InMemoryBaseRepository<SecurityStaff> implements SecurityStaffRepository {
    @Override
    protected String extractId(SecurityStaff entity) {
        return entity.getId();
    }
}
