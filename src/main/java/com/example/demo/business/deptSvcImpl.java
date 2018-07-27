package com.example.demo.business;

import com.example.demo.business.svc.deptSvc;
import com.example.demo.data.DAO.deptDAOImpl;
import com.example.demo.data.deptDAO;
import com.example.demo.entity.dept;
import com.example.demo.util.enums.ResultMessageEnum;

public class deptSvcImpl implements deptSvc {

    deptDAO dao= deptDAOImpl.getInstance();

    @Override
    public dept getDept(int deptID) throws Exception {
        return dao.getDept(deptID);
    }

    @Override
    public ResultMessageEnum addAdMark(int deptID,int mark) throws Exception {
        return dao.addAdMark(mark,deptID);
    }

    @Override
    public ResultMessageEnum addNotMark(int deptID,int mark) throws Exception {
        return dao.addNotAdMark(mark,deptID);
    }
}
