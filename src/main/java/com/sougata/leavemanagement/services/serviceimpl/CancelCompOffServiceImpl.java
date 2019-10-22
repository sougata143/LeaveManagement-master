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

import com.sougata.leavemanagement.component.CancelCompOffComponent;
import com.sougata.leavemanagement.dto.LeaveActivityResponse;
import com.sougata.leavemanagement.services.CancelCompOffService;

@Service
public class CancelCompOffServiceImpl implements CancelCompOffService {

	@Autowired
	private CancelCompOffComponent compOffCancelDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelCompOffServiceImpl.class);

	@Override
	public ResponseEntity<LeaveActivityResponse> cancelCompOff(String userId, Date leaveStartDate, Date leaveEnddate,
			String locationId, String unitId) {

		ResponseEntity<LeaveActivityResponse> response = compOffCancelDao.cancelCompOff(userId, leaveStartDate,
				leaveEnddate, locationId, unitId);

		return response;
	}

}
