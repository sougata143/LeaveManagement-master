package com.sougata.leavemanagement.services.serviceimpl;

import static com.sougata.leavemanagement.constant.LeaveManagementConstant.USER_HOST_SERVER;

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

import com.sougata.leavemanagement.component.RaiseCompOffDailyComponent;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.RaiseCompOffService;

@Service
public class RaiseCompOffServiceImpl implements RaiseCompOffService {

	@Autowired
	private RaiseCompOffDailyComponent compOffRaiseDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(RaiseCompOffServiceImpl.class);

	@Override
	public ResponseEntity<LeaveActivityResponse> raiseCompOff(String inWeekEnd1, String inWeekEnd2, String inAltr,
			long inHolidayCnt, String inRaisedVal) {

		String responseMsg;
		HttpStatus httpStatus;
		try {
			compOffRaiseDao.raiseCompOff(inWeekEnd1, inWeekEnd2, inAltr, inHolidayCnt, inRaisedVal);
			responseMsg = "CompOff Raised Successfully";
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			LOGGER.error("exception while Raising CompOff for user by Id {} , leave apply details {},  {}", inWeekEnd1,
					inWeekEnd2 + "~" + inAltr + "~" + inHolidayCnt + "~" + inRaisedVal, e.getMessage());
			responseMsg = "CompOff could not be raised";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
		}
		LeaveActivityResponse leaveActivityResponse = new LeaveActivityResponse();
		leaveActivityResponse.setResponseCode(httpStatus.toString());
		leaveActivityResponse.setResponseMessage(responseMsg);
		return new ResponseEntity<LeaveActivityResponse>(leaveActivityResponse, httpStatus);
	}

}
