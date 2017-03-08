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

			System.out.println("�s�W���u�s�� : " + empVO.getEmpno());
			
			
			//���ɨ�listOneEmp.zul
			Map<String, Object> parameter = new HashMap<String, Object>();

			Execution exection = Executions.getCurrent();

			parameter.put("emp_selectPage_toListOne_empno", empVO.getEmpno());

			Session session = Sessions.getCurrent();
			session.setAttribute("emp_selectPage_toListOne_params", parameter);

			exection.sendRedirect(("/emp/listOneEmp.zul"));
			
		} else {
			if (empVO.getComm() == null) {
				System.out.println("�п�J�Ī�");
			}

			if (empVO.getDeptno() == null) {
				System.out.println("�п�J�����s��");
			}

			if (empVO.getEname() == null) {
				System.out.println("�п�J�m�W");
			}

			if (empVO.getJob() == null) {
				System.out.println("�п�J¾��");
			}

			if (empVO.getHiredate() == null) {
				System.out.println("�п�J�N¾��");
			}

			if (empVO.getSal() == null) {
				System.out.println("�п�J�~��");
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
