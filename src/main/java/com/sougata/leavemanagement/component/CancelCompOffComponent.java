package com.sougata.leavemanagement.component;

import java.sql.Date;

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
public class CancelCompOffComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelCompOffComponent.class);

	@Autowired
	DataSource dataSource;

	@PersistenceContext
	private EntityManager entityManager;

	public ResponseEntity<LeaveActivityResponse> cancelCompOff(String userId, Date leaveStartDate, Date leaveEnddate,
			String locationId, String unitId) {
		String responseMsg;
		HttpStatus httpStatus;

		try {
			String query = "BEGIN USER_COMPOFF_CANCEL_PROC(:IN_USER_ID, :IN_LEAVE_START_DATE, :IN_LEAVE_END_DATE, "
					+ ":IN_LOCATION_ID, :IN_UNIT_ID); END;";
			entityManager.createNativeQuery(query).setParameter("IN_USER_ID", userId)
					.setParameter("IN_LEAVE_START_DATE", leaveStartDate).setParameter("IN_LEAVE_END_DATE", leaveEnddate)
					.setParameter("IN_LOCATION_ID", locationId).setParameter("IN_UNIT_ID", unitId).executeUpdate();

			responseMsg = "Comp Off Successfully Cancelled";
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			LOGGER.error("exception while canceling CompOff for user by Id {} , leave apply details {},  {}", userId,
					userId + "~" + leaveStartDate + "~" + leaveEnddate + "~" + locationId + "~" + unitId,
					e.getMessage());
			responseMsg = "Comp Off could not be Cancelled";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
		}

		LeaveActivityResponse leaveActivityResponse = new LeaveActivityResponse();
		leaveActivityResponse.setResponseCode(httpStatus.toString());
		leaveActivityResponse.setResponseMessage(responseMsg);
		return new ResponseEntity<LeaveActivityResponse>(leaveActivityResponse, httpStatus);
	}

}
