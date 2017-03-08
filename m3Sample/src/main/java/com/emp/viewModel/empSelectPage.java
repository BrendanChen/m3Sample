package com.emp.viewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zsoup.helper.StringUtil;
import org.zkoss.zul.ListModelList;

import com.emp.model.EmpSearchCondition;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class empSelectPage {

	/** 員工Service */
	@WireVariable(value = "empService")
	private EmpService empService;

	/** 員工主檔 */
	private EmpVO empVO;

	/** 員工查詢條件 */
	private EmpVO empSearchCondition;

	/** 員工List */
	private List<EmpVO> empList;
	
	/** 員工編號list*/
	private List<Integer> empnoList;

	public List<Integer> getEmpnoList() {
		return empnoList;
	}

	public void setEmpnoList(List<Integer> empnoList) {
		this.empnoList = empnoList;
	}

	@Init
	public void init() {

		empSearchCondition = new EmpVO();

		empVO = new EmpVO();
		
		empnoList = new ArrayList<Integer>();

		empList = empService.getAll();
		
		for(EmpVO empData: empList){
			empnoList.add(empData.getEmpno());
		}

	}
	
	@Command
	public void lookEmpData(@BindingParam("empVO") EmpVO empVO) {
		
		Map<String, Object> parameter = new HashMap<String, Object>();

		Execution exection = Executions.getCurrent();

		parameter.put("emp_selectPage_toListOne_empno", empVO.getEmpno());

		Session session = Sessions.getCurrent();
		session.setAttribute("emp_selectPage_toListOne_params", parameter);

		exection.sendRedirect(("/emp/listOneEmp.zul"));
	}
	
	public List<EmpVO> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmpVO> empList) {
		this.empList = empList;
	}

	public EmpVO getEmpVO() {
		return empVO;
	}

	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}

	public EmpVO getEmpSearchCondition() {
		return empSearchCondition;
	}

	public void setEmpSearchCondition(EmpVO empSearchCondition) {
		this.empSearchCondition = empSearchCondition;
	}

	@Command
	public void queryEmpData() {

		empVO = empService.findByPrimaryKey(empSearchCondition);

		if (empVO != null) {
			lookEmpData(empVO);
		}
	}
}