package com.example.demo.data.DAO;

import com.example.demo.data.userDAO;
import com.example.demo.entity.userList;
import com.example.demo.util.enums.ResultMessageEnum;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class userDAOImpl implements userDAO {

    private static class userDAOImplHolder{
        private static final userDAOImpl INSTANCE=new userDAOImpl();
    }

    public static final userDAOImpl getInstance(){return userDAOImplHolder.INSTANCE;}

    @Override
    public synchronized ResultMessageEnum addPerson(String name) throws Exception{
        userList users=null;
        String path="/Users/yangyang/assets/users.json";

        String file=readFile(path);

        Gson gson=new Gson();
        users=gson.fromJson(file,userList.class);

        users.addUser(name);

        String jsonStr=gson.toJson(users);

        return writeFile(path,jsonStr);
    }

    @Override
    public synchronized ResultMessageEnum judgeIsDone(String name) throws Exception{
        userList users=null;
        String path="/Users/yangyang/assets/users.json";

        String file=readFile(path);

        Gson gson=new Gson();
        users=gson.fromJson(file,userList.class);

        return users.judgeIsDone(name);

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
