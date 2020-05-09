package com.jy.controller.menu;

import com.jy.model.user.User;
import com.jy.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("toLogin")
    String toLoginPage(){
        return "login";
    }

}
