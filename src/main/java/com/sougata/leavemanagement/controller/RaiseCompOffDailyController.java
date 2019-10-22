package com.sougata.leavemanagement.controller;

import static com.sougata.leavemanagement.constant.LeaveManagementConstant.USER_HOST_SERVER;

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
import com.sougata.leavemanagement.services.RaiseCompOffService;

@RestController
@RequestMapping("/easybusiness/leave/")
public class RaiseCompOffDailyController {

	@Autowired
	RaiseCompOffService raisecompoffdailyService;
	
	@CrossOrigin(origins = USER_HOST_SERVER)
    @PostMapping(value = "raisecompoff/{inWeekEnd1}/{inWeekEnd2}/{inAltr}/{inHolidayCnt}/{inRaisedVal}")
    @ResponseBody
    public ResponseEntity<LeaveActivityResponse> raiseCompOff(@PathVariable("inWeekEnd1") String inWeekEnd1,
	    @PathVariable("inWeekEnd2") String inWeekEnd2, @PathVariable("inAltr") String inAltr,
	    @PathVariable("inHolidayCnt") long inHolidayCnt, @PathVariable("inRaisedVal") String inRaisedVal) {
		return raisecompoffdailyService.raiseCompOff(inWeekEnd1, inWeekEnd2, inAltr, inHolidayCnt, inRaisedVal);
	}
	
}
