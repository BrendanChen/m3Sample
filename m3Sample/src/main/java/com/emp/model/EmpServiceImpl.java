package com.emp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.data.dao.EmployeeDAO;



@Service("empService")
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	private EmpVO empVO = new EmpVO();
		
	
	@Override
	public void insert(EmpVO empVO) {
		employeeDAO.insert(empVO);
	}

	@Override
	public void update(EmpVO empVO) {
		employeeDAO.update(empVO);
	}

	@Override
	public void delete(Integer empno) {
		employeeDAO.delete(empno);
	}

	@Override
	public EmpVO findByPrimaryKey(EmpVO empSearchCondition) {
		
		empVO = employeeDAO.findByPrimaryKey(empSearchCondition);
		
		return empVO;
		
	}

	@Override
	public List<EmpVO> getAll() {
		
		List<EmpVO> empList = new ArrayList<EmpVO>();
		empList = employeeDAO.getAll();
		return empList;
	}
	
	
}
