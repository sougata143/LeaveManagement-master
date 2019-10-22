package com.sougata.leavemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sougata.leavemanagement.entity.LocationMaster;

@Repository
public interface LocationMasterRepository extends JpaRepository<LocationMaster, Long> {

    List<LocationMaster> findAll();

    List<LocationMaster> findById(Long id);

}
