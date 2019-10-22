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
public class ModifyLeaveComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelCompOffComponent.class);

	@Autowired
	DataSource dataSource;

	@PersistenceContext
	private EntityManager entityManager;

	public ResponseEntity<LeaveActivityResponse> modifyOrCancelLeave(String operationType, String userId,
			String leaveTypeId, String leaveTransactionId, String leaveStartDate, String leaveEnddate,
			String locationId, String unitId, String dayType) {
		String responseMsg;
		HttpStatus httpStatus;
		try {
			String query = "BEGIN USER_LEAVE_MODORCAN_PROC(:IN_OPERATION_TYPE, :IN_USER_ID, :IN_LEAVE_TYPE_ID, "
					+ ":IN_LEAVE_TRAN_ID, :IN_LEAVE_START_DATE, :IN_LEAVE_END_DATE, :IN_LOCATION_ID, :IN_UNIT_ID, "
					+ ":IN_DAY_TYPE); END;";
			entityManager.createNativeQuery(query).setParameter("IN_OPERATION_TYPE", operationType)
					.setParameter("IN_USER_ID", userId).setParameter("IN_LEAVE_TYPE_ID", leaveTypeId)
					.setParameter("IN_LEAVE_TRAN_ID", leaveTransactionId)
					.setParameter("IN_LEAVE_START_DATE", leaveStartDate).setParameter("IN_LEAVE_END_DATE", leaveEnddate)
					.setParameter("IN_LOCATION_ID", locationId).setParameter("IN_UNIT_ID", unitId)
					.setParameter("IN_DAY_TYPE", dayType).executeUpdate();

			responseMsg = operationType + "Leave Successfully Done";
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			LOGGER.error(
					"exception while " + operationType + "ing"
							+ " leave for user by Id {} , leave apply details {},  {}",
					userId, userId + "~" + leaveTypeId + "~" + leaveStartDate + "~" + leaveEnddate + "~" + locationId
							+ "~" + unitId + "~" + dayType,
					e.getMessage());
			responseMsg = operationType + " Leave could not be  Done";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
		}
		LeaveActivityResponse leaveActivityResponse = new LeaveActivityResponse();
		leaveActivityResponse.setResponseCode(httpStatus.toString());
		leaveActivityResponse.setResponseMessage(responseMsg);
		return new ResponseEntity<LeaveActivityResponse>(leaveActivityResponse, httpStatus);
	}

}
