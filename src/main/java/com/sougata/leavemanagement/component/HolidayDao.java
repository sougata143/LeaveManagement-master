package com.sougata.leavemanagement.component;

import java.sql.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sougata.leavemanagement.entity.HolidayMaster;
import com.sougata.leavemanagement.entity.LocationMaster;
import com.sougata.leavemanagement.repository.HolidayRepository;

@Component
public class HolidayDao {

	@Autowired
	HolidayRepository holidayRepository;

	@Autowired
	UserDao userDao;

	public HolidayMaster findByHolidayId(Long holidayMasterId) {
		return holidayRepository.findOne(holidayMasterId);
	}

	public List<HolidayMaster> findByHolidayDate(Date holidayDate) {
		return holidayRepository.findByHolidayDate(holidayDate);
	}

	public List<HolidayMaster> findByHolidayTypeAndHolidayYear(String holidayType, Long holidayYear) {
		return holidayRepository.findByHolidayTypeAndHolidayYear(holidayType, holidayYear);
	}

	public List<HolidayMaster> findByHolidayYear(Long holidayYear) {
		return holidayRepository.findByHolidayYear(holidayYear);
	}

	public List<HolidayMaster> findHolidayByLocationAndHolidayYear(LocationMaster locationMaster, Long holidayYear) {

		return holidayRepository.findByLocationMasterAndHolidayYear(locationMaster, holidayYear);
	}

	public List<HolidayMaster> findAll() {
		return holidayRepository.findAll();
	}

	public HolidayMaster addHolidayMaster(HolidayMaster holidayMaster)

	{
		return holidayRepository.save(holidayMaster);
	}

	public void deleteHolidayMaster(Long holidayId)

	{
		holidayRepository.delete(holidayId);
	}

}
