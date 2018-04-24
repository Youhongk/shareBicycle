package com.gduf.sbcms.entity;

public class Bicycle {
    private Integer bicycleId; //车辆id

    private Integer bicycleStatus; //车辆状态

    private String coordinates; //坐标

    private String regional; //区域

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public Integer getBicycleStatus() {
        return bicycleStatus;
    }

    public void setBicycleStatus(Integer bicycleStatus) {
        this.bicycleStatus = bicycleStatus;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional == null ? null : regional.trim();
    }
}