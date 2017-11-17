package com.wellCh4n.dingtalk.Controller;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wellCh4n.dingtalk.Servlet.UserInfoServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static javafx.scene.input.KeyCode.H;

/**
 * @author wellCh4n
 * @DESCRIPTION
 * @create 2017/11/15 13:51
 */

@Controller
public class TestController {

    @GetMapping(value = "/test")
    public String helloHtml(Map<String,Object> map,HttpServletRequest request){
        map.put("config",AuthHelper.getConfig(request));

//        String config = AuthHelper.getConfig(request);
//        JSONObject obj = JSON.parseObject(config);
//        UserInfoServlet.login(obj.getString("agentid"),obj.getString("corpId"));

        map.put("test","testvalue");
        return "index";
    }
}
