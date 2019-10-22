package com.sougata.leavemanagement.services;

import org.springframework.http.ResponseEntity;

import com.sougata.leavemanagement.dto.LeaveActivityResponse;

public interface ModifyLeaveService {

    public ResponseEntity<LeaveActivityResponse> modifyOrCancelLeave(String operationType, String userId, String leaveTypeId,
	    String leaveTransactionId, String leaveStartDate, String leaveEnddate, String locationId, String unitId,
	    String dayType);

}
