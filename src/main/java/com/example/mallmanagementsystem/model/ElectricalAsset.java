package com.example.mallmanagementsystem.model;

public class ElectricalAsset {
    private String id;
    private String floorId;
    private ElectricalAssetType type;
    private ElectricalAssetStatus status;

    public ElectricalAsset(String id, String floorId, ElectricalAssetType type, ElectricalAssetStatus status) {
        this.id = id;
        this.floorId = floorId;
        this.type = type;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public ElectricalAssetType getType() {
        return type;
    }

    public void setType(ElectricalAssetType type) {
        this.type = type;
    }

    public ElectricalAssetStatus getStatus() {
        return status;
    }

    public void setStatus(ElectricalAssetStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ElectricalAsset{" +
                "id='" + id + '\'' +
                ", floorId='" + floorId + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
