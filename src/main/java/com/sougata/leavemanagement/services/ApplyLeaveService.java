package com.sougata.leavemanagement.services;

import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sougata.leavemanagement.dto.ApplyLeaveDTO;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;

@Service
public interface ApplyLeaveService {

	public ResponseEntity<LeaveActivityResponse> applyLeave(long userId, long leaveTypeId, Date leaveStartDate,
			Date leaveEnddate, long locationId, long unitId, String dayType);
	
	public ResponseEntity<LeaveActivityResponse> applyLeaveBody(ApplyLeaveDTO dto);

}
