package com.example.demo.business;

import com.example.demo.business.svc.empSvc;
import com.example.demo.data.DAO.empDAOImpl;
import com.example.demo.data.empDAO;
import com.example.demo.entity.employee;
import com.example.demo.util.enums.ResultMessageEnum;
import org.springframework.stereotype.Service;

@Service
public class empSvcImpl implements empSvc {

    empDAO dao=empDAOImpl.getInstance();

    @Override
    public ResultMessageEnum addFrontMark (int empID,int mark) throws Exception{

        return dao.addFrontMark(empID,mark);
    }

    @Override
    public ResultMessageEnum addBackMark (int empID,int mark) throws Exception{

        return dao.addBackMark(empID,mark);
    }

    @Override
    public employee getEmp(int empID) throws Exception{

        return dao.getEmployee(empID);
    }
}
