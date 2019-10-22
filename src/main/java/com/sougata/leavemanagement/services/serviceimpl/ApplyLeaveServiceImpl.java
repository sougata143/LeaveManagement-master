
package com.sougata.leavemanagement.services.serviceimpl;

import static com.sougata.leavemanagement.constant.LeaveManagementConstant.USER_HOST_SERVER;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sougata.leavemanagement.component.ApplyLeaveComponent;
import com.sougata.leavemanagement.dto.ApplyLeaveDTO;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.ApplyLeaveService;

@Service
public class ApplyLeaveServiceImpl implements ApplyLeaveService {

	@Autowired
	private ApplyLeaveComponent leaveApplyDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyLeaveServiceImpl.class);

	@Override
	public ResponseEntity<LeaveActivityResponse> applyLeave(long userId, long leaveTypeId, Date leaveStartDate,
			Date leaveEnddate, long locationId, long unitId, String dayType) {

		ResponseEntity<LeaveActivityResponse> response = leaveApplyDao.applyLeave(userId, leaveTypeId, leaveStartDate,
				leaveEnddate, locationId, unitId, dayType);

		return response;
	}

	@Override
	public ResponseEntity<LeaveActivityResponse> applyLeaveBody(ApplyLeaveDTO dto) {
		long userId = dto.getUserId();
		long leaveTypeId = dto.getLeaveTypeId();
		Date leaveStartDate = dto.getLeaveStartDate();
		Date leaveEnddate = dto.getLeaveEnddate();
		long locationId = dto.getLocationId();
		long unitId = dto.getUnitId();
		String dayType = dto.getDayType();
		ResponseEntity<LeaveActivityResponse> response = leaveApplyDao.applyLeave(userId, leaveTypeId, leaveStartDate,
				leaveEnddate, locationId, unitId, dayType);
		return response;
	}

}
