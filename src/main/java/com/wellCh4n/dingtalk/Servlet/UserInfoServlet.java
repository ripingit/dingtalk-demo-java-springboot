package com.wellCh4n.dingtalk.Servlet;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.alibaba.dingtalk.openapi.demo.user.UserHelper;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author wellCh4n
 * @DESCRIPTION
 * @create 2017/11/15 17:02
 */
@RestController
public class UserInfoServlet {

    @GetMapping(value = "/userinfo")
    public CorpUserDetail noLogin(
            @RequestParam(value = "code",required = true) String code ,
            @RequestParam(value = "corpid",required = true) String corpid){
        System.out.println("authCode:" + code + " corpid:" + corpid);
        try {
            String accessToken = AuthHelper.getAccessToken();
            System.out.println("access_token:" +accessToken);
            CorpUserDetail user = UserHelper.getUser(accessToken, UserHelper.getUserInfo(accessToken, code).getUserid());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CorpUserDetail();
    }

    @PostMapping(value = "/saveUserId")
    public void saveId(@RequestParam(value = "userid",required = true) String userid,HttpSession session){
        session.setAttribute("userid",userid);
    }
}
