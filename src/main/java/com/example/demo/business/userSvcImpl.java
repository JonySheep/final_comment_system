package com.example.demo.business;

import com.example.demo.business.svc.userSvc;
import com.example.demo.data.DAO.userDAOImpl;
import com.example.demo.data.userDAO;
import com.example.demo.util.enums.ResultMessageEnum;

public class userSvcImpl implements userSvc {

    userDAO dao= userDAOImpl.getInstance();

    @Override
    public ResultMessageEnum addPerson(String name) throws Exception{
        return dao.addPerson(name);
    }

    @Override
    public ResultMessageEnum judgeIsDone(String name) throws Exception{
        return dao.judgeIsDone(name);
    }
}
