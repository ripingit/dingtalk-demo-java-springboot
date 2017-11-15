package com.wellCh4n.dingtalk.Controller;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
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
        map.put("test","testvalue");
        return "index";
    }
}
