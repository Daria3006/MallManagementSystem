package com.example.mallmanagementsystem.model;

public class SecurityStaff extends Staff{
    private String badgeNo;

    public SecurityStaff(String id, String name, String badgeNo) {
        super(id, name);
        this.badgeNo = badgeNo;
    }

    public String getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(String badgeNo) {
        this.badgeNo = badgeNo;
    }

    @Override
    public String toString() {
        return "SecurityStaff{" +
                "BadgeNo='" + badgeNo + '\'' +
                ", id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
