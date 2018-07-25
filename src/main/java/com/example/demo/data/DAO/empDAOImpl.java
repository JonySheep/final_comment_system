package com.example.demo.data.DAO;

import com.example.demo.app.WebAppConfig;
import com.example.demo.data.empDAO;
import com.example.demo.entity.empList;
import com.example.demo.entity.employee;
import com.example.demo.util.enums.ResultMessageEnum;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class empDAOImpl implements empDAO {
    private static class empDAOImplHolder{
        private static final empDAOImpl INSTANCE=new empDAOImpl();
    }

    public static final empDAOImpl getInstance(){
        return empDAOImplHolder.INSTANCE;
    }


    @Override
    public synchronized employee getEmployee(int empID) throws Exception {

        empList emps=null;
        String path= WebAppConfig.BASE+"/assets/employee.json";

        String file=readFile(path);

        Gson gson=new Gson();
        emps=gson.fromJson(file,empList.class);

        if(emps.getEmpList()!=null){
            for(employee e:emps.getEmpList()){
                if(e.getID()==empID){
                    return e;
                }
            }
        }

        return null;
    }

    @Override
    public ResultMessageEnum addFrontMark(int empID, int mark) throws Exception {
        empList emps=null;
        String path=WebAppConfig.BASE+"/assets/employee.json";

        String file=readFile(path);

        Gson gson=new Gson();
        emps=gson.fromJson(file,empList.class);

        if(emps.getEmpList()!=null){
            for(employee e:emps.getEmpList()){
                if(e.getID()==empID){
                    e.addFrontMark(mark);
                    break;
                }
            }
        }

        employee currentEmp=getEmployee(empID);
        currentEmp.addFrontMark(mark);

        String jsonStr=gson.toJson(currentEmp);

        return writeFile(path,jsonStr);
    }

    @Override
    public ResultMessageEnum addBackMark(int empID, int mark) throws Exception {
        empList emps=null;
        String path=WebAppConfig.BASE+"/assets/employee.json";

        String file=readFile(path);

        Gson gson=new Gson();
        emps=gson.fromJson(file,empList.class);

        if(emps.getEmpList()!=null){
            for(employee e:emps.getEmpList()){
                if(e.getID()==empID){
                    e.addBackMark(mark);
                    break;
                }
            }
        }

        employee currentEmp=getEmployee(empID);
        currentEmp.addFrontMark(mark);

        String jsonStr=gson.toJson(currentEmp);

        return writeFile(path,jsonStr);
    }


    /**
     * 用来读取文件
     * @param path 路径
     * @return
     * @throws Exception
     */
    private String readFile(String path) throws Exception {
        String str = "";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line = reader.readLine()) != null) {
            str = str + line;
        }
        return str;
    }


    /**
     * 用来写文件
     * @param path 路径
     * @param str 写内容
     * @return
     * @throws Exception
     */
    private ResultMessageEnum writeFile(String path, String str) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(str);
        bw.close();
        return ResultMessageEnum.SUCCESS;
    }
}