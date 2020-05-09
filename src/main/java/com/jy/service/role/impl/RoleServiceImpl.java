package com.jy.service.role.impl;

import com.jy.mapper.role.RoleMapper;
import com.jy.model.role.Role;
import com.jy.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Map<String,Object> selectRoleList(Role role) {
        Map<String, Object> map = new HashMap<>();
        List<Role> list = roleMapper.selectRoleList(role);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", list);
//        map.put("count", 0);
        return map;
    }

    @Override
    public void updateRoleMenuList(List<Role> list) {
        //删除该角色对应的原来的所有菜单
        roleMapper.deleteRoleMenuList(list.get(0));
        //保存该角色对应的最新的所有菜单
        roleMapper.insertRoleMenuList(list);
    }

    @Override
    public void insertRole(Role role) {
        roleMapper.insertRole(role);
    }

    @Override
    public void deleteRoleInfoByID(Role role) {
        //删除角色表中的当前角色信息
        roleMapper.delectRoleInfoByID(role);
        //删除角色菜单中间表中当前角色与菜单的对应信息
        roleMapper.deleteRoleMenuMappingInfoByID(role);
        //删除用户角色中间表中当前角色与用户的对应信息
        roleMapper.deleteUserRoleMappingInfoByID(role);
    }

    @Override
    public void updateUserRoleList(List<Role> list) {
        //删除用户原来对应的角色
        roleMapper.deleteRoleList(list.get(0));
        //保存用户最新对应的角色
        roleMapper.insertRoleList(list);
    }
}
