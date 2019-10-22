package com.sougata.leavemanagement.controller;

import static com.sougata.leavemanagement.constant.LeaveManagementConstant.USER_HOST_SERVER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.ModifyLeaveService;

@RestController
@RequestMapping("/leave/")
public class ModifyLeaveController {

	@Autowired
	ModifyLeaveService modifyleaveService;

	@CrossOrigin(origins = USER_HOST_SERVER)
	@RequestMapping(value = "modifyorcancelleave/{operationType}/{userId}/{leaveTypeId}/{leaveTransactionId}/{leaveStartDate}/{leaveEnddate}/{locationId}/{unitId}/{dayType}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<LeaveActivityResponse> modifyOrCancelLeave(
			@PathVariable("operationType") String operationType, @PathVariable("userId") String userId,
			@PathVariable("leaveTypeId") String leaveTypeId,
			@PathVariable("leaveTransactionId") String leaveTransactionId,
			@PathVariable("leaveStartDate") String leaveStartDate, @PathVariable("leaveEnddate") String leaveEnddate,
			@PathVariable("locationId") String locationId, @PathVariable("unitId") String unitId,
			@PathVariable("dayType") String dayType) {
		return modifyleaveService.modifyOrCancelLeave(operationType, userId, leaveTypeId, leaveTransactionId,
				leaveStartDate, leaveEnddate, locationId, unitId, dayType);
	}

}
