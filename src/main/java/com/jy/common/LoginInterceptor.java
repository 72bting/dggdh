package com.jy.common;

import com.jy.model.menu.Menu;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        //从session中取出用户信息，判断用户是否登录
        HttpSession session = request.getSession();
        Map<String,Object> userInfo = (Map<String,Object>)session.getAttribute("suserInfo");
        if (null != userInfo && userInfo.get("code").toString().equals("1")){
            //已登录用户
            //获取到当前请求的地址信息
            String requestURI = request.getRequestURI();
            if (requestURI.endsWith("/index") || requestURI.endsWith("/toNoPermision")) {
                return true;
            }
            //获取session中存储的首页左侧菜单树
            Object menuList = session.getAttribute("menulsit");
            if (null != menuList) {
                List<Menu> list = (List<Menu>) menuList;
                for (Menu m : list) {
                    List<Menu> mlist = m.getMenuList();
                    for (Menu m2 : mlist) {
                        if (null != m2.getMenuHref() && requestURI.endsWith(m2.getMenuHref())) {
                            //该用户拥有此权限
                            return true;
                        }
                    }
                }
            }
            //该用户没有此权限，跳转到无权限页面
            response.sendRedirect(   request.getContextPath() + "/toNoPermision");
            return false;
        }else{
            //未登录，重定向用户到登录页面
            response.sendRedirect(request.getContextPath() + "/toLogin");
        }
        return flag;
    }
}
