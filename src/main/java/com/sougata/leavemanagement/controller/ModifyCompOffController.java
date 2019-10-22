package com.sougata.leavemanagement.controller;

import static com.sougata.leavemanagement.constant.LeaveManagementConstant.USER_HOST_SERVER;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.ModifyCompOffService;

@RestController
@RequestMapping("/leave/")
public class ModifyCompOffController {

	@Autowired
	ModifyCompOffService modifycompoffService;
	
	@CrossOrigin(origins = USER_HOST_SERVER)
    @PostMapping(value = "modifycompoff/{userId}/{leaveStartDate}/{leaveEnddate}/{locationId}/{unitId}")
    @ResponseBody
    public ResponseEntity<LeaveActivityResponse> modifyCompOff(
    		@PathVariable("userId") String userId,
		    @PathVariable("leaveStartDate") Date leaveStartDate,
		    @PathVariable("leaveEnddate") Date leaveEnddate,
		    @PathVariable("locationId") String locationId, 
		    @PathVariable("unitId") String unitId) {
		return modifycompoffService.modifyCompOff(userId, leaveStartDate, leaveEnddate, locationId, unitId);
	}
	
}
