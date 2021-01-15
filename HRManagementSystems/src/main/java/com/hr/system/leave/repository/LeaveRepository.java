package com.hr.system.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.leave.bean.LeavesAccessBean;

@Repository
public interface LeaveRepository extends JpaRepository<LeavesAccessBean, Long> {

	List<LeavesAccessBean> findAllByStatus(String string);

	LeavesAccessBean findByLeavesId(Long leavesId);

	

}
