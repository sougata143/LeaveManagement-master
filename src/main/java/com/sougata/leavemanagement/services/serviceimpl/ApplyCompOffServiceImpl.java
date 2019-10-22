package com.sougata.leavemanagement.services.serviceimpl;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sougata.leavemanagement.component.ApplyCompOffComponent;
import com.sougata.leavemanagement.dto.ApplyCompOffDTO;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.ApplyCompOffService;

@Service
public class ApplyCompOffServiceImpl implements ApplyCompOffService {

	@Autowired
	private ApplyCompOffComponent compOffApplyDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyCompOffServiceImpl.class);

	@Override
	public ResponseEntity<LeaveActivityResponse> applyCompOff(String userId, String leaveTypeId, Date leaveStartDate,
			Date leaveEnddate, String locationId, String unitId) {

		ResponseEntity<LeaveActivityResponse> response = compOffApplyDao.applyCompOffProc(userId, leaveTypeId,
				leaveStartDate, leaveEnddate, locationId, unitId);

		return response;
	}

	@Override
	public ResponseEntity<LeaveActivityResponse> applyCompOffBody(ApplyCompOffDTO applyCompOffDTO) {
		String userId = applyCompOffDTO.getUserId(); 
		String leaveTypeId = applyCompOffDTO.getLeaveTypeId();
		Date leaveStartDate = applyCompOffDTO.getLeaveStartDate();
		Date leaveEnddate = applyCompOffDTO.getLeaveEnddate();
		String locationId = applyCompOffDTO.getLocationId();
		String unitId = applyCompOffDTO.getUnitId();
		
		ResponseEntity<LeaveActivityResponse> response = compOffApplyDao.applyCompOffProc(userId, leaveTypeId,
				leaveStartDate, leaveEnddate, locationId, unitId);
		return response;
	}

}
