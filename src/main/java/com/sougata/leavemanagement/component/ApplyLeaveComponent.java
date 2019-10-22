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
public class ApplyLeaveComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyLeaveComponent.class);

	@Autowired
	DataSource dataSource;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public ResponseEntity<LeaveActivityResponse> applyLeave(long inUserId, long inLeaveTypeId, Date inLeaveStartDate,
			Date inLeaveEnddate, long inLocationId, long inUnitId, String inDayType) {
		String responseMsg;
		HttpStatus httpStatus;

		// try {
		String query = "BEGIN USER_LEAVE_APPLY_PROC(:IN_USER_ID, :IN_LEAVE_TYPE_ID, :IN_LEAVE_START_DATE,"
				+ " :IN_LEAVE_END_DATE, :IN_LOCATION_ID, :IN_UNIT_ID, :IN_DAY_TYPE); END;";

		entityManager.createNativeQuery(query).setParameter("IN_USER_ID", inUserId)
				.setParameter("IN_LEAVE_TYPE_ID", inLeaveTypeId).setParameter("IN_LEAVE_START_DATE", inLeaveStartDate)
				.setParameter("IN_LEAVE_END_DATE", inLeaveEnddate).setParameter("IN_LOCATION_ID", inLocationId)
				.setParameter("IN_UNIT_ID", inUnitId).setParameter("IN_DAY_TYPE", inDayType).executeUpdate();
		responseMsg = "Leave Successfully Applied";
		httpStatus = HttpStatus.OK;
		/*
		 * }catch (Exception e) { responseMsg = "Leave could not be Applied"; httpStatus
		 * = HttpStatus.EXPECTATION_FAILED; }
		 */

		LeaveActivityResponse leaveActivityResponse = new LeaveActivityResponse();
		leaveActivityResponse.setResponseCode(httpStatus.toString());
		leaveActivityResponse.setResponseMessage(responseMsg);
		return new ResponseEntity<LeaveActivityResponse>(leaveActivityResponse, httpStatus);
	}

}
