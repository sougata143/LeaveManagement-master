package com.sougata.leavemanagement.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sougata.leavemanagement.entity.LeaveMaster;
import com.sougata.leavemanagement.repository.LeaveMasterRepository;
import com.sougata.leavemanagement.repository.UserRepository;

@Component
public class LeaveMasterDao {

	@Autowired
	LeaveMasterRepository leaveMasterRepository;

	@Autowired
	UserRepository userRepository;

	public LeaveMaster findByLeaveTypeId(Long leaveTypeId) {
		return leaveMasterRepository.findOne(leaveTypeId);
	}

	public LeaveMaster findByLeaveType(String leaveType) {
		return leaveMasterRepository.findByLeaveType(leaveType).get(0);
	}

	public List<LeaveMaster> findAll() {
		return leaveMasterRepository.findAll();
	}

	public void deleteLeaveMaster(Long leaveTypeId)

	{
		leaveMasterRepository.delete(leaveTypeId);
	}

}
