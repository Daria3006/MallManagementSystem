package com.example.mallmanagementsystem.model;

public class SecurityStaff extends Staff{
    private String BadgeNo;

    public SecurityStaff(String id, String name, String badgeNo) {
        super(id, name);
        BadgeNo = badgeNo;
    }

    public String getBadgeNo() {
        return BadgeNo;
    }

    public void setBadgeNo(String badgeNo) {
        BadgeNo = badgeNo;
    }

    @Override
    public String toString() {
        return "SecurityStaff{" +
                "BadgeNo='" + BadgeNo + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
