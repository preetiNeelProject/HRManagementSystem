package com.hr.system.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.leave.bean.LeaveTypeAccessBean;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveTypeAccessBean, Long> {

	LeaveTypeAccessBean findByLeaveTypeId(Long leaveTypeId);

}
