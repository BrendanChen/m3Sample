package com.emp.model;

import java.util.List;

public interface EmpService {
	
    public void insert(EmpVO empVO);
    public void update(EmpVO empVO);
    public void delete(Integer empno);
    public EmpVO findByPrimaryKey(EmpVO empSearchCondition);
    public List<EmpVO> getAll();
	
}
