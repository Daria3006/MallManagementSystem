package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.SecurityStaff;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Repository
@Primary
public class InFileSecurityStaffRepository extends InFileBaseRepository<SecurityStaff> {
    public InFileSecurityStaffRepository(@Value("${repository.securityStaff.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId(SecurityStaff securityStaff) {
        return securityStaff.getId();
    }

    @Override
    protected TypeReference<List<SecurityStaff>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
