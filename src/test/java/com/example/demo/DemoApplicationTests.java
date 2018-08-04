package com.example.demo;

import com.example.demo.business.deptSvcImpl;
import com.example.demo.business.empSvcImpl;
import com.example.demo.business.svc.deptSvc;
import com.example.demo.business.svc.empSvc;
import com.example.demo.business.svc.userSvc;
import com.example.demo.business.userSvcImpl;
import com.example.demo.entity.dept;
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
	deptSvc deptService=new deptSvcImpl();
	userSvc userSvc=new userSvcImpl();

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


	@Test
	public void getDept1() throws Exception{
		dept resDept=deptService.getDept(1);
		assertEquals(resDept.getID(),1);
	}


	@Test
	public void getDept2() throws Exception{
		dept resDept=deptService.getDept(7);
		assertEquals(resDept.getID(),7);
	}


	@Test
	public void addAdMark() throws Exception{
		ResultMessageEnum res=deptService.addAdMark(1,80);
		assertEquals(deptService.getDept(1).getAdMark(),80);
	}


	@Test
	public void addNotAdMark() throws Exception{
		ResultMessageEnum res=deptService.addNotMark(1,70);
		assertEquals(deptService.getDept(1).getNotAdMark().size(),4);
	}


	@Test
	public void getMark() throws Exception{
		ResultMessageEnum res=deptService.addNotMark(1,85);
		assertEquals(deptService.getDept(1).getMark(),81.875,0.01);
	}


	@Test
	public void addUser1() throws Exception{
		ResultMessageEnum res=userSvc.addPerson("YangYuqin");
		assertEquals(userSvc.judgeIsDone("YangYuqin"),ResultMessageEnum.FAIL);
	}

	@Test
	public void addUser2() throws Exception{
		assertEquals(userSvc.judgeIsDone("Yu"),ResultMessageEnum.SUCCESS);
	}
}
