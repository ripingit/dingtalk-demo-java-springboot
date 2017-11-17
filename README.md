# dingtalk-demo-springboot
> 整合来自 [openapi-demo-java](https://github.com/open-dingtalk/openapi-demo-java)

## 注意
* 首次使用记得在 `Env` 类里面设置 `CORP_ID` 和 `CORP_SECRET`。
* 使用 `thymeleaf` 作为模板。

### 整合进度
* 2017/11/14 实现Demo，添加依赖。
* 2017/11/15 实现免登，用 RestController 的方式重写 UserInfoServlet，改动官方生成用户信息的JSON方式。
````
//原方法
String configValue = "{jsticket:'" + ticket + "',signature:'" + signature + "',nonceStr:'" + nonceStr + "',timeStamp:'"
                + timeStamp + "',corpId:'" + Env.CORP_ID + "',agentid:'" + agentid + "'}";


//现方法
Map<String,Object> preJson = new HashMap<String,Object>();
preJson.put("jsticket",ticket);
preJson.put("signature",signature);
preJson.put("nonceStr",nonceStr);
preJson.put("timeStamp",timeStamp);
preJson.put("corpId",Env.CORP_ID);
preJson.put("agentid",agentid);
String configValue = JSON.toJSONString(preJson);

````
* 2017/11/17 把 jsapi 里获取到的 `userid` 异步提交到 `session` 中，key值为 `userid` 。
````
//把之前官方的 ajax 添加 async : false
$.ajax({
    async : false,
    url : 'saveUserId?userid=' + info.userid,
    type: 'POST'
});