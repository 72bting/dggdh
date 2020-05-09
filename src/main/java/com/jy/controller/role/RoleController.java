package com.jy.controller.role;

import com.jy.model.role.Role;
import com.jy.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("role/toList")
    String toRoleListPage(){
        return "role/list";
    }

    @RequestMapping("role/list")
    @ResponseBody
    Map<String,Object> selectRoleList (Role role){
        Map<String,Object> map = roleService.selectRoleList(role);
        return map;
    }

    @RequestMapping("role/toSetup")
    String toSetUp(Role role, Model model){
        model.addAttribute("role",role);
        return "role/setup";
    }

    @RequestMapping("role/setupMenuTree")
    @ResponseBody
    String updateRoleMenuList(@RequestBody List<Role> list){
        roleService.updateRoleMenuList(list);
        return "{}";
    }

    @RequestMapping("role/toAddRolePage")
    String toAddRolePage(){
        return "role/add";
    }

    @RequestMapping("role/insert")
    @ResponseBody
    String insertRole(Role role){
        roleService.insertRole(role);
        return "{}";
    }

    @PostMapping("role/delete")
    @ResponseBody
    String deleteRoleInfoByID(Role role){
        roleService.deleteRoleInfoByID(role);
        return "{}";
    }

}
