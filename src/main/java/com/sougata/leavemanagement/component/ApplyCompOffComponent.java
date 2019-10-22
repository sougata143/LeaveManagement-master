package com.sougata.leavemanagement.component;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.sougata.leavemanagement.dto.LeaveActivityResponse;

@Component
public class ApplyCompOffComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyCompOffComponent.class);

	@Autowired
	DataSource dataSource;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public ResponseEntity<LeaveActivityResponse> applyCompOffProc(String userId, String leaveTypeId,
			Date leaveStartDate, Date leaveEnddate, String locationId, String unitId) {
		String responseMsg;
		HttpStatus httpStatus;

		try {
			String query = "BEGIN USER_COMPOFF_APPLY_PROC(:IN_USER_ID, :IN_LEAVE_TYPE_ID, :IN_LEAVE_START_DATE, :IN_LEAVE_END_DATE, "
					+ "IN_LOCATION_ID, IN_UNIT_ID); END;\"";
			entityManager.createNativeQuery(query).setParameter("IN_USER_ID", userId)
					.setParameter("IN_LEAVE_TYPE_ID", leaveTypeId).setParameter("IN_LEAVE_START_DATE", leaveStartDate)
					.setParameter("IN_LEAVE_END_DATE", leaveEnddate).setParameter("IN_LOCATION_ID", locationId)
					.setParameter("IN_UNIT_ID", unitId).executeUpdate();
			responseMsg = "CompOff Successfully Applied";
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			responseMsg = "CompOff could not be Applied";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
		}

		LeaveActivityResponse leaveActivityResponse = new LeaveActivityResponse();
		leaveActivityResponse.setResponseCode(httpStatus.toString());
		leaveActivityResponse.setResponseMessage(responseMsg);
		return new ResponseEntity<LeaveActivityResponse>(leaveActivityResponse, httpStatus);
	}

}
