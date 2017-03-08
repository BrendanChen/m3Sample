package com.emp.viewModel;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Window;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class addEmpPage {

	@WireVariable
	private EmpService empService;

	@Init
	public void init() {

		empVO = new EmpVO();

	}

	@Command
	public void addEmpData() {

		//empVO.setEmpno(1);

		if (!StringUtils.isEmpty(empVO.getComm()) &&
				!StringUtils.isEmpty(empVO.getDeptno()) &&
						!StringUtils.isEmpty(empVO.getEname()) &&
						!StringUtils.isEmpty(empVO.getHiredate()) &&
						!StringUtils.isEmpty(empVO.getJob()) &&
						!StringUtils.isEmpty(empVO.getSal())) {

			empService.insert(empVO);

			System.out.println("新增員工編號 : " + empVO.getEmpno());
			
			
			//重導到listOneEmp.zul
			Map<String, Object> parameter = new HashMap<String, Object>();

			Execution exection = Executions.getCurrent();

			parameter.put("emp_selectPage_toListOne_empno", empVO.getEmpno());

			Session session = Sessions.getCurrent();
			session.setAttribute("emp_selectPage_toListOne_params", parameter);

			exection.sendRedirect(("/emp/listOneEmp.zul"));
			
		} else {
			if (empVO.getComm() == null) {
				System.out.println("請輸入傭金");
			}

			if (empVO.getDeptno() == null) {
				System.out.println("請輸入部門編號");
			}

			if (empVO.getEname() == null) {
				System.out.println("請輸入姓名");
			}

			if (empVO.getJob() == null) {
				System.out.println("請輸入職稱");
			}

			if (empVO.getHiredate() == null) {
				System.out.println("請輸入就職日");
			}

			if (empVO.getSal() == null) {
				System.out.println("請輸入薪水");
			}
		}

	}

	public EmpVO getEmpVO() {
		return empVO;
	}

	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}

	private EmpVO empVO;

}
