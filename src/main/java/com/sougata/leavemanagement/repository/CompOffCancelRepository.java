package com.sougata.leavemanagement.repository;

import java.sql.Date;

public interface CompOffCancelRepository {
    
    public void compOffCancelForUser(String userId,Date leaveStartDate,Date leaveEnddate,String locationId,String unitId);

}
