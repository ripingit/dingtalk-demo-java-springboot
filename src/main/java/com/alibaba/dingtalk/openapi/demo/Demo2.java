package com.alibaba.dingtalk.openapi.demo;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.alibaba.dingtalk.openapi.demo.department.DepartmentHelper;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.open.client.api.model.corp.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wellCh4n
 * @DESCRIPTION
 * @create 2017/11/15 10:46
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{

        List<Department> departmentList = new ArrayList<Department>();
        departmentList = DepartmentHelper.listDepartments(AuthHelper.getAccessToken(),"1");
        JSONObject usersJSON = new JSONObject();
        System.out.println("depart num:" + departmentList.size());

    }
}
