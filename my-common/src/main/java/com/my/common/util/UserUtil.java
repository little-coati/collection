package com.my.common.util;


import com.nariit.pi6000.ua.po.User;
import com.nariit.pi6000.ua.session.HttpSessionManager;
import com.nariit.pi6000.ua.session.OnlineUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: tianyuanlong
 * @date: 2020/4/28
 */
public class UserUtil {
    public static User getUser(){
       HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       User user = (User)getAttribute(request, "auth_user");
       return user;
   }


    public static String getUserById(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User)getAttribute(request, "auth_user");
        String userId = user.getId();
        if(StringUtils.isBlank(userId)){
            Assert.notNull(userId, "userId为空!");
        }else{
            String baseOrgUnitId = user.getBaseOrgUnitId();
            if(StringUtils.equals("99",baseOrgUnitId)){
                return null;
            }
        }
        return userId;
    }
    public static Object getAttribute(ServletRequest request, String key) {
        Assert.notNull(request, "request参数不能为空!");
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession(false);
        return session != null ? session.getAttribute(key) : null;
    }

    public static OnlineUser getOnlineUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        OnlineUser onlineUser = HttpSessionManager.getOnlineUser(request);
        return onlineUser;
    }

}
