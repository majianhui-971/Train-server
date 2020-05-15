package com.entity;

import java.util.Date;

public class Line {
    private Integer id;

    private Integer driveId;

    private String driveNumber;

    private String startSite;

    private String startSiteName;

    private String endSite;

    private String endSiteName;

    private String passSite;

    private String passSiteName;

    private String offsetTime;

    private Date startTime;

    private Date endTime;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartSite() {
        return startSite;
    }

    public void setStartSite(String startSite) {
        this.startSite = startSite == null ? null : startSite.trim();
    }

    public String getEndSite() {
        return endSite;
    }

    public void setEndSite(String endSite) {
        this.endSite = endSite == null ? null : endSite.trim();
    }

    public String getPassSite() {
        return passSite;
    }

    public void setPassSite(String passSite) {
        this.passSite = passSite == null ? null : passSite.trim();
    }

    public String getOffsetTime() {
        return offsetTime;
    }

    public void setOffsetTime(String offsetTime) {
        this.offsetTime = offsetTime == null ? null : offsetTime.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStartSiteName() {
        return startSiteName;
    }

    public void setStartSiteName(String startSiteName) {
        this.startSiteName = startSiteName;
    }

    public String getEndSiteName() {
        return endSiteName;
    }

    public void setEndSiteName(String endSiteName) {
        this.endSiteName = endSiteName;
    }

    public String getPassSiteName() {
        return passSiteName;
    }

    public void setPassSiteName(String passSiteName) {
        this.passSiteName = passSiteName;
    }

    public Integer getDriveId() {
        return driveId;
    }

    public void setDriveId(Integer driveId) {
        this.driveId = driveId;
    }

    public String getDriveNumber() {
        return driveNumber;
    }

    public void setDriveNumber(String driveNumber) {
        this.driveNumber = driveNumber;
    }
}