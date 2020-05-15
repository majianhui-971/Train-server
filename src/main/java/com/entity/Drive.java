package com.entity;

public class Drive {
    private Integer id;

    private String driverName;

    private String driveAge;

    private String capacity;

    private String driveNumber;

    private String emptyCapacity;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getDriveAge() {
        return driveAge;
    }

    public void setDriveAge(String driveAge) {
        this.driveAge = driveAge == null ? null : driveAge.trim();
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public String getDriveNumber() {
        return driveNumber;
    }

    public void setDriveNumber(String driveNumber) {
        this.driveNumber = driveNumber == null ? null : driveNumber.trim();
    }

    public String getEmptyCapacity() {
        return emptyCapacity;
    }

    public void setEmptyCapacity(String emptyCapacity) {
        this.emptyCapacity = emptyCapacity == null ? null : emptyCapacity.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}