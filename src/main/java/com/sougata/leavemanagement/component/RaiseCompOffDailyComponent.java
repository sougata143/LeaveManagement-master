package com.sougata.leavemanagement.component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.sougata.leavemanagement.dto.LeaveActivityResponse;

@Component
public class RaiseCompOffDailyComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelCompOffComponent.class);

	@Autowired
	DataSource dataSource;

	@PersistenceContext
	private EntityManager entityManager;

	public ResponseEntity<LeaveActivityResponse> raiseCompOff(String inWeekEnd1, String inWeekEnd2, String inAltr,
			long inHolidayCnt, String inRaisedVal) {
		String responseMsg;
		HttpStatus httpStatus;
		try {
			String query = "BEGIN USER_COMPOFF_RAISE_DAILY_PROC(:IN_WEEK_END1, :IN_WEEK_END2, :IN_ALTR, :IN_HOLIDAY_CNT,"
					+ " :IN_RAISED_VAL); END;";
			entityManager.createNativeQuery(query).setParameter("IN_WEEK_END1", inWeekEnd1)
					.setParameter("IN_WEEK_END2", inWeekEnd2).setParameter("IN_ALTR", inAltr)
					.setParameter("IN_HOLIDAY_CNT", inHolidayCnt).setParameter("IN_RAISED_VAL", inRaisedVal).executeUpdate();
			responseMsg = "CompOff Raised Successfully";
		    httpStatus = HttpStatus.OK;
		}catch (Exception e) {
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
