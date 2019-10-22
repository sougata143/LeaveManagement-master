package com.sougata.leavemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sougata.leavemanagement.entity.LeaveBalance;
import com.sougata.leavemanagement.entity.LeaveMaster;
import com.sougata.leavemanagement.entity.User;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {

    List<LeaveBalance> findAll();

    List<LeaveBalance> findById(Long id);

    List<LeaveBalance> findByUser(User user);

    List<LeaveBalance> findByLeaveMaster(LeaveMaster leavemaster);

    List<LeaveBalance> findByUserAndLeaveMaster(User user, LeaveMaster leavemaster);

    
}
