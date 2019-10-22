package com.sougata.leavemanagement.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface LeaveUpdateUserCreationRepository {
    
    void leaveUpdateForUserCreation(String userId);

}
