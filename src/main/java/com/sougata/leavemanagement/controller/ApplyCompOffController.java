package com.sougata.leavemanagement.controller;

import static com.sougata.leavemanagement.constant.LeaveManagementConstant.USER_HOST_SERVER;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sougata.leavemanagement.dto.ApplyCompOffDTO;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.ApplyCompOffService;

@RestController
@RequestMapping("/leave/")
public class ApplyCompOffController {

	@Autowired
	ApplyCompOffService compoffService;

	@CrossOrigin(origins = USER_HOST_SERVER)
	@PostMapping(value = "applycompoff/{userId}/{leaveTypeId}/{leaveStartDate}/{leaveEnddate}/{locationId}/{unitId}")
	@ResponseBody
	public ResponseEntity<LeaveActivityResponse> applyCompOff(@PathVariable("userId") String userId,
			@PathVariable("leaveTypeId") String leaveTypeId, @PathVariable("leaveStartDate") Date leaveStartDate,
			@PathVariable("leaveEnddate") Date leaveEnddate, @PathVariable("locationId") String locationId,
			@PathVariable("unitId") String unitId) {
		return compoffService.applyCompOff(userId, leaveTypeId, leaveStartDate, leaveEnddate, locationId, unitId);
	}
	
	@CrossOrigin(origins = USER_HOST_SERVER)
	@PostMapping(value = "applycompoff")
	@ResponseBody
	
	public ResponseEntity<LeaveActivityResponse> applyCompOffBody(@RequestBody ApplyCompOffDTO dto) {
		return compoffService.applyCompOffBody(dto);
	}

}
