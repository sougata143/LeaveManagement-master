package com.sougata.leavemanagement.services;

import java.sql.Date;

import org.springframework.http.ResponseEntity;

import com.sougata.leavemanagement.dto.LeaveActivityResponse;

public interface CancelCompOffService {

    public ResponseEntity<LeaveActivityResponse> cancelCompOff(String userId, Date leaveStartDate, Date leaveEnddate,
	    String locationId, String unitId);

}
