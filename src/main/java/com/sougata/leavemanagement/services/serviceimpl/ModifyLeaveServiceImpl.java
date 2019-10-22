package com.sougata.leavemanagement.services.serviceimpl;

import static com.sougata.leavemanagement.constant.LeaveManagementConstant.USER_HOST_SERVER;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sougata.leavemanagement.component.ModifyLeaveComponent;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.ModifyLeaveService;

@Service
public class ModifyLeaveServiceImpl implements ModifyLeaveService {

	@Autowired
	private ModifyLeaveComponent leaveModifyOrCancelDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ModifyLeaveServiceImpl.class);

	@Override
	public ResponseEntity<LeaveActivityResponse> modifyOrCancelLeave(String operationType, String userId,
			String leaveTypeId, String leaveTransactionId, String leaveStartDate, String leaveEnddate,
			String locationId, String unitId, String dayType) {

		ResponseEntity<LeaveActivityResponse> response = leaveModifyOrCancelDao.modifyOrCancelLeave(operationType,
				userId, leaveTypeId, leaveTransactionId, leaveStartDate, leaveEnddate, locationId, unitId, dayType);

		return response;
	}

}
