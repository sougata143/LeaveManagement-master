package com.sougata.leavemanagement.dto;

import java.sql.Date;

public class ApplyLeaveDTO {

	private long userId;
	private long leaveTypeId;
	private Date leaveStartDate;
	private Date leaveEnddate;
	private long locationId;
	private long unitId;
	private String dayType;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEnddate() {
		return leaveEnddate;
	}
	public void setLeaveEnddate(Date leaveEnddate) {
		this.leaveEnddate = leaveEnddate;
	}
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	public long getUnitId() {
		return unitId;
	}
	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
	public String getDayType() {
		return dayType;
	}
	public void setDayType(String dayType) {
		this.dayType = dayType;
	}
}
