package com.sougata.leavemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sougata.leavemanagement.entity.LeaveMaster;
import com.sougata.leavemanagement.entity.LeaveTransaction;
import com.sougata.leavemanagement.entity.User;

@Repository
public interface LeaveTransactionRepository
		extends JpaRepository<LeaveTransaction, Long>, JpaSpecificationExecutor<LeaveTransaction> {

	List<LeaveTransaction> findAll();

	List<LeaveTransaction> findById(Long id);

	List<LeaveTransaction> findByUser(User user);

	List<LeaveTransaction> findByLeaveMaster(LeaveMaster leavemaster);

	List<LeaveTransaction> findByUserAndLeaveMaster(User user, LeaveMaster leavemaster);

	List<LeaveTransaction> findByStatus(String status);

}
