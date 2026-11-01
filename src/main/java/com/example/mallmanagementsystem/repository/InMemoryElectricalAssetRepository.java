package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.ElectricalAsset;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryElectricalAssetRepository extends InMemoryBaseRepository<ElectricalAsset> implements ElectricalAssetRepository{

    @Override
    protected String extractId(ElectricalAsset entity) {
        return entity.getId();
    }
}
