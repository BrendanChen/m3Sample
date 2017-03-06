package com.emp.data.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.emp.model.EmpSearchCondition;
import com.emp.model.EmpVO;

public interface EmployeeDAO {
	
	/**
	 * �H�e���d�߱���i��d��
	 * @param empSearchCondition
	 * @return List<EmpVO>
	 */
	public EmpVO findByPrimaryKey(EmpVO empSearchCondition);
	
	
	/**
	 * �d�ߥ���
	 * @return List<EmpVO>
	 */
	
	public List<EmpVO> getAll();
	
	
}
