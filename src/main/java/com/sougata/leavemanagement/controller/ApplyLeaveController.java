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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sougata.leavemanagement.dto.ApplyLeaveDTO;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.ApplyLeaveService;

@RestController
@RequestMapping("/leave/")
public class ApplyLeaveController {

	@Autowired
	ApplyLeaveService applyleaveService;

	@CrossOrigin(origins = USER_HOST_SERVER)
	@PostMapping(value = "applyleaveparam")
	@ResponseBody
	public ResponseEntity<LeaveActivityResponse> applyLeave(@RequestParam("userId") long userId,
			@RequestParam("leaveTypeId") long leaveTypeId, @RequestParam("leaveStartDate") Date leaveStartDate,
			@RequestParam("leaveEnddate") Date leaveEnddate, @RequestParam("locationId") long locationId,
			@RequestParam("unitId") long unitId, @RequestParam("dayType") String dayType) {
		return applyleaveService.applyLeave(userId, leaveTypeId, leaveStartDate, leaveEnddate, locationId, unitId,
				dayType);
	}

	@CrossOrigin(origins = USER_HOST_SERVER)
	@PostMapping(value = "applyleave/{userId}/{leaveTypeId}/{leaveStartDate}/{leaveEnddate}/{locationId}/{unitId}/{dayType}")
	@ResponseBody
	public ResponseEntity<LeaveActivityResponse> applyLeaveParam(@PathVariable("userId") long userId,
			@PathVariable("leaveTypeId") long leaveTypeId, @PathVariable("leaveStartDate") Date leaveStartDate,
			@PathVariable("leaveEnddate") Date leaveEnddate, @PathVariable("locationId") long locationId,
			@PathVariable("unitId") long unitId, @PathVariable("dayType") String dayType) {
		return applyleaveService.applyLeave(userId, leaveTypeId, leaveStartDate, leaveEnddate, locationId, unitId,
				dayType);
	}

	@CrossOrigin(origins = USER_HOST_SERVER)
	@PostMapping(value = "applyleave")
	@ResponseBody
	public ResponseEntity<LeaveActivityResponse> applyLeaveBody(@RequestBody ApplyLeaveDTO dto) {
		return applyleaveService.applyLeaveBody(dto);
	}

}
