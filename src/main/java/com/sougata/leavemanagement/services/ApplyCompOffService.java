package com.sougata.leavemanagement.services;

import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sougata.leavemanagement.dto.ApplyCompOffDTO;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;

@Service
public interface ApplyCompOffService {

    public ResponseEntity<LeaveActivityResponse> applyCompOff(String userId, String leaveTypeId, Date leaveStartDate,
	    Date leaveEnddate, String locationId, String unitId);
    
    public ResponseEntity<LeaveActivityResponse> applyCompOffBody(ApplyCompOffDTO applyCompOffDTO);

}
