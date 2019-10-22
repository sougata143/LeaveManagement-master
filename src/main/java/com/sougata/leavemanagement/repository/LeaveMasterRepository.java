package com.sougata.leavemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sougata.leavemanagement.entity.LeaveMaster;

@Repository
public interface LeaveMasterRepository extends JpaRepository<LeaveMaster, Long> {
    
    List<LeaveMaster> findAll();
    List<LeaveMaster> findById(Long id);
    List<LeaveMaster> findByLeaveType(String leaveType);
}
