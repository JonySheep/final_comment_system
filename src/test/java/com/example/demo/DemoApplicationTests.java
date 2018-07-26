package com.example.demo;

import com.example.demo.business.empSvcImpl;
import com.example.demo.business.svc.empSvc;
import com.example.demo.entity.employee;
import com.example.demo.util.enums.ResultMessageEnum;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

public class DemoApplicationTests {

	//Emp Test
	empSvc svc=new empSvcImpl();

	@Test
	public void addFrontMark() throws Exception{
		ResultMessageEnum result=svc.addFrontMark(1,90);
		employee emp=svc.getEmp(1);
		assertEquals(emp.getFrontMarkList().size(),1);
	}


	@Test
	public void frontMark() throws Exception{
		ResultMessageEnum res=svc.addFrontMark(1,95);
		employee emp=svc.getEmp(1);
		assertEquals(emp.getFrontMark(),92.5,0.01);
	}


	@Test
	public void addBackMark() throws Exception{
		ResultMessageEnum result=svc.addBackMark(1,90);
		employee emp=svc.getEmp(1);
		assertEquals(emp.getBackMarkList().size(),1);
	}


	@Test
	public void backMark() throws Exception{
		ResultMessageEnum res=svc.addBackMark(1,95);
		employee emp=svc.getEmp(1);
		assertEquals(emp.getBackMark(),92.5,0.01);
	}




}
