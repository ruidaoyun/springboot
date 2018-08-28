package com.belle.springboot.controller;

import com.belle.springboot.commons.JwtHelper;
import com.belle.springboot.commons.RedisUtil;
import com.belle.springboot.commons.RegexUtils;
import com.belle.springboot.pojo.Audience;
import com.belle.springboot.pojo.LoginUser;
import com.belle.springboot.service.LoginUserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginUserController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private Audience audience;

    @GetMapping("getAudience")
    public Audience getAudience(){
        return audience;
    }

    @PostMapping("/login")
    public Map login(
            @RequestParam("loginInfo")String loginInfo,
            @RequestParam("password")String password,
            HttpServletRequest request
    ){
        HashMap<String, Object> map=new HashMap<> ();
        LoginUser loginUser=new LoginUser ();
        if(RegexUtils.checkEmail (loginInfo)){
            loginUser.setEmail (loginInfo);
        }else if(RegexUtils.checkPhone (loginInfo)){
            loginUser.setTelephone (loginInfo);
        }else{
            loginUser.setUsername (loginInfo);
        }
        LoginUser user=loginUserService.login (loginUser);
        if (user==null||!password.equals (user.getPassword ())){
            map.put ("error","用户名或密码错误");
            return map;
        }
        if(audience == null){
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            audience = (Audience) factory.getBean("audience");
        }
        String jwt=JwtHelper.createJWT (
                user.getUsername (),
                user.getId (),
                audience.getClientId (),
                audience.getName (),
                audience.getExpiresSecond () * 1000,
                audience.getBase64Secret ());
        map.put ("ok","bearer;"+jwt);
        //redisUtil.set (jwt,user.getId ());
        //redisUtil.expire (jwt,5*60);
        //System.err.print (redisUtil.get (jwt));
        return map;
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map unauthorized() {
        HashMap<String, Object> map=new HashMap<> ();
        map.put ("error","unauthorized");
        return map;
    }

    @GetMapping("/expire")
    public Map expire(){
        HashMap<String, Object> map=new HashMap<> ();
        map.put ("error","token过期");
        return map;
    }


}
