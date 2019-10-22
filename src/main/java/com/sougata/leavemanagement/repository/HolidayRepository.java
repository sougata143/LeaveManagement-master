package com.sougata.leavemanagement.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sougata.leavemanagement.entity.HolidayMaster;
import com.sougata.leavemanagement.entity.LocationMaster;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayMaster, Long> {

    List<HolidayMaster> findAll();

    List<HolidayMaster> findById(Long id);

    List<HolidayMaster> findByHolidayDate(Date holidayDate);

    List<HolidayMaster> findByHolidayTypeAndHolidayYear(String holidayType,Long holidayYear);

    List<HolidayMaster> findByHolidayYear(Long holidayYear);

    List<HolidayMaster> findByLocationMasterAndHolidayYear(LocationMaster locationMaster, Long holidayYear);

    

}
