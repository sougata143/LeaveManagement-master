package com.sougata.leavemanagement.dto;

import java.sql.Date;

public class ApplyCompOffDTO {

	private String userId; 
	private String leaveTypeId;
	private Date leaveStartDate;
	private Date leaveEnddate;
	private String locationId;
	private String unitId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(String leaveTypeId) {
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
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
}
