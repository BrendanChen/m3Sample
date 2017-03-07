package com.emp.viewModel;

import javax.swing.text.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.WireVariable;

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
	public void addEmpData(){
		
		if(StringUtils.isEmpty(empVO)){
		
			empService.insert(empVO);
			
			System.out.println("�s�W���u�s�� : "+empVO.getEmpno());
			
		}else{
			System.out.println("�п�J���!");
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
