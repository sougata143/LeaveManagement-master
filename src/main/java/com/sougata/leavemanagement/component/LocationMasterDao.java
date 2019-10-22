package com.sougata.leavemanagement.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sougata.leavemanagement.entity.LocationMaster;
import com.sougata.leavemanagement.repository.LocationMasterRepository;

@Component
public class LocationMasterDao {

	@Autowired
	LocationMasterRepository locationMasterRepository;

	@Autowired
	UserDao userDao;

	public LocationMaster findById(Long locationId) {
		return locationMasterRepository.findOne(locationId);
	}

}
