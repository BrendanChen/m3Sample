package com.emp.data.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.emp.model.EmpSearchCondition;
import com.emp.model.EmpVO;

public interface EmployeeDAO {
	
	/**
	 * 礶琩高兵ン秈︽琩高
	 * @param empSearchCondition
	 * @return List<EmpVO>
	 */
	public EmpVO findByPrimaryKey(EmpVO empSearchCondition);
	
	
	/**
	 * 琩高场
	 * @return List<EmpVO>
	 */
	
	public List<EmpVO> getAll();
	
	
}
