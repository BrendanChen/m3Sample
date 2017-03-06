package com.emp.viewModel;

import java.util.Map;

import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.emp.model.EmpSearchCondition;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class empListOnePage {
	
	private Map<String, Object> params;
	
	@WireVariable(value = "empService")
	private EmpService empService;
	
	
	private EmpVO empVO;
	
	public EmpVO getEmpVO() {
		return empVO;
	}



	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}



	public Map<String, Object> getParams() {
		return params;
	}



	public void setParams(Map<String, Object> params) {
		this.params = params;
	}



	@Init
	public void init(){
		
		empVO = new EmpVO();
		
		params = (Map<String, Object>) Sessions.getCurrent().getAttribute("emp_selectPage_toListOne_params");
		
		//先找回員工主檔
		empVO.setEmpno((Integer) params.get("emp_selectPage_toListOne_empno"));
		
		EmpSearchCondition empSearchCondition = new EmpSearchCondition();
		
		empSearchCondition.setEmpno(empVO.getEmpno());
		
		empVO = empService.findByPrimaryKey(empSearchCondition);
		
	}
	
}
