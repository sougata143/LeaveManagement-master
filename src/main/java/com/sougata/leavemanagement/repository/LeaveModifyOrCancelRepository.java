package com.sougata.leavemanagement.repository;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public interface LeaveModifyOrCancelRepository {
    
    public void leaveModifyOrCancelForUser(String operationType,String userId,String leaveTypeId,String leaveTransactionId,Date leaveStartDate,Date leaveEnddate,String locationId,String unitId,String dayType);

}
