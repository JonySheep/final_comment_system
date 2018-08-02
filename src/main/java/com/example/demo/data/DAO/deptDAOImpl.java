package com.example.demo.data.DAO;

import com.example.demo.app.WebAppConfig;
import com.example.demo.data.deptDAO;
import com.example.demo.entity.dept;
import com.example.demo.entity.deptList;
import com.example.demo.util.enums.ResultMessageEnum;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class deptDAOImpl implements deptDAO {

    private static class deptDAOImplHolder{
        private static final deptDAOImpl INSTANCE=new deptDAOImpl();
    }

    public static final deptDAOImpl getInstance(){
        return deptDAOImplHolder.INSTANCE;
    }

    @Override
    public dept getDept(int deptID) throws Exception {
        deptList depts=null;

        String path= "/assets/dept.json";
        //String path="/Users/yangyang/assets/dept.json";

        String file=readFile(path);

        Gson gson=new Gson();
        depts=gson.fromJson(file,deptList.class);

        if(depts.getDeptList()!=null){
            for(dept e:depts.getDeptList()){
                if(e.getID()==deptID){
                    return e;
                }
            }
        }

        return null;
    }


    @Override
    public ResultMessageEnum addAdMark(int mark, int deptID) throws Exception {
        deptList depts=null;
        String path="/assets/dept.json";
        //String path="/Users/yangyang/assets/dept.json";

        String file=readFile(path);

        Gson gson=new Gson();
        depts=gson.fromJson(file,deptList.class);

        if(depts.getDeptList()!=null){
            for(dept e:depts.getDeptList()){
                if(e.getID()==deptID){
                    e.addAdMark(mark);

                    //calculate average
                    double sum=0;
                    for(int i:e.getNotAdMark()){
                        sum+=i;
                    }

                    if(e.getComment_num()!=0){
                        e.setMark(mark*0.5+(sum/e.getComment_num())*0.5);
                    }

                    break;
                }
            }
        }

        String jsonStr=gson.toJson(depts);

        return writeFile(path,jsonStr);
    }

    @Override
    public ResultMessageEnum addNotAdMark(int mark, int deptID) throws Exception {
        deptList depts=null;
        String path="/assets/dept.json";
        //String path="/Users/yangyang/assets/dept.json";

        String file=readFile(path);

        Gson gson=new Gson();
        depts=gson.fromJson(file,deptList.class);

        if(depts.getDeptList()!=null){
            for(dept e:depts.getDeptList()){
                if(e.getID()==deptID){
                    e.addNotAdMark(mark);
                    e.addCommentNum();

                    //calculate average
                    double sum=0;
                    for(int i:e.getNotAdMark()){
                        sum+=i;
                    }

                    if(e.getComment_num()!=0){
                        e.setMark(e.getAdMark()*0.5+(sum/e.getComment_num())*0.5);
                    }

                    break;
                }
            }
        }

        String jsonStr=gson.toJson(depts);

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
