package com.emp.viewModel;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class updateEmpPage {
	
	private Map<String,Object> params;
	
	/**員工主檔*/
	private EmpVO empVO;
	
	/**empService*/
	@WireVariable(value="empService")
	private EmpService empService;
	
	public Map<String, Object> getParams() {
		return params;
	}


	public void setParams(Map<String, Object> params) {
		this.params = params;
	}


	public EmpVO getEmpVO() {
		return empVO;
	}


	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}


	@Init
	public void init(){
		
		params = new HashMap<String,Object>();
		
		empVO = new EmpVO();
		
		params = (Map<String, Object>) Sessions.getCurrent().getAttribute("emp_listOnePage_toUpdateEmpPage_params");
		
		empVO.setEmpno((Integer)params.get("emp_ListOnePage_toUpdatePage_empno"));
		
		empVO = empService.findByPrimaryKey(empVO);
	}
	
	@Command
	public void saveEmpData(){
		
		empService.update(empVO);
		
		System.out.println("更新完成...");
		
		//重導到listOneEmp.zul
		params = new HashMap<String, Object>();

		Execution exection = Executions.getCurrent();

		params.put("emp_selectPage_toListOne_empno", empVO.getEmpno());

		Session session = Sessions.getCurrent();
		session.setAttribute("emp_selectPage_toListOne_params", params);

		exection.sendRedirect(("/emp/listOneEmp.zul"));
	}
}
