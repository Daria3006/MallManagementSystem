package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.ElectricalAsset;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class InFileElectricalAssetRepository extends InFileBaseRepository<ElectricalAsset>{

    public InFileElectricalAssetRepository(@Value("${repository.electricalAsset.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId(ElectricalAsset electricalAsset) {
        return electricalAsset.getId();
    }

    @Override
    protected TypeReference<List<ElectricalAsset>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
