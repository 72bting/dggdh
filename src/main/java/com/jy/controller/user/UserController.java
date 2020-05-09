package com.jy.controller.user;

import com.jy.model.role.Role;
import com.jy.model.user.User;
import com.jy.service.role.RoleService;
import com.jy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/login")
    @ResponseBody
    Map<String,Object> toLogin(HttpServletRequest request, User user){
        Map<String,Object> map = new HashMap<>();
        HttpSession sessioncode = request.getSession();
        String randomcode = sessioncode.getAttribute("RANDOMVALIDATECODEKEY").toString();
        if (randomcode.equalsIgnoreCase(user.getRandomCode())){
            map = userService.login(user);
            //获取session对象
            HttpSession session = request.getSession();
            //把用户信息放在session中
            session.setAttribute("suserInfo",map);
        }else{
            map.put("code",3);
        }
        return map;
    }

    @GetMapping("user/toList")
    String toUserListPage(){
        return "user/list";
    }

    @RequestMapping("user/list")
    @ResponseBody
    Map<String, Object> selectUserList(User user) {
        Map<String, Object> map = userService.selectUserList(user);
        return map;
    }

    @GetMapping("user/toSetup")
    String toSetupRolePage(User user,ModelMap mm) {
        //查询出角色列表（用户对应的要勾选）
        Role r = new Role();
        r.setUserID(user.getUserID());
        Map<String, Object> map = roleService.selectRoleList(r);
        mm.addAttribute("list", map.get("data"));
        return "user/setup";
    }

    @RequestMapping("user/setupRole")
    @ResponseBody
    String updateUserRoleList(@RequestBody List<Role> list){
        roleService.updateUserRoleList(list);
        return "{}";
    }

    @RequestMapping("user/delete")
    @ResponseBody
    String deleteUserByID(User user){
        userService.deleteUserByID(user);
        return "{}";
    }

    @RequestMapping("user/toAddUserPage")
    String toAddUserPage(User user){
        return "user/add";
    }

    @RequestMapping("user/insert")
    @ResponseBody
    Map<String,Object> insertUser(User user,ModelMap modelMap){
        Map<String,Object> map =  userService.insertUser(user);
        return map;
    }
}
