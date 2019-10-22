package com.sougata.leavemanagement.services;

import org.springframework.http.ResponseEntity;

import com.sougata.leavemanagement.dto.LeaveActivityResponse;

public interface RaiseCompOffService {

    
	ResponseEntity<LeaveActivityResponse> raiseCompOff(String inWeekEnd1, String inWeekEnd2, String inAltr,
			long inHolidayCnt, String inRaisedVal);

}
