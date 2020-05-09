package com.jy.service.role;

import com.jy.model.role.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    Map<String,Object> selectRoleList(Role role);

    void updateRoleMenuList(List<Role> list);

    void insertRole(Role role);

    void deleteRoleInfoByID(Role role);

    void updateUserRoleList(List<Role> list);
}
