package com.emp.data.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.emp.model.EmpSearchCondition;
import com.emp.model.EmpVO;

public interface EmployeeDAO {
	
	/**
	 * 以畫面查詢條件進行查詢
	 * @param empSearchCondition
	 * @return List<EmpVO>
	 */
	public EmpVO findByPrimaryKey(EmpVO empSearchCondition);
	
	
	/**
	 * 查詢全部
	 * @return List<EmpVO>
	 */
	
	public List<EmpVO> getAll();
	
	
	/** 新增員工*/
	public void insert(EmpVO empVO);
	
	
	/** 修改員工資料*/
	public void update(EmpVO empVO);
	
	/** 刪除員工資料*/
	public void delete(Integer empno);
}
