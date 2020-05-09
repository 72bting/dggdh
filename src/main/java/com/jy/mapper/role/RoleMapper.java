package com.jy.mapper.role;

import com.jy.model.role.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {


    @Select("SELECT r.r_id roleID, r.r_name roleName," +
            " (case when urmid2.t_role_id is null then 0 else 1 end) checked" +
            " from t_roles r" +
            " left join (select t_role_id from t_u_r_mids urmid" +
            " where t_user_id = #{userID}) urmid2" +
            " on r.r_id = urmid2.t_role_id")
    List<Role> selectRoleList(Role role);

    @Delete("delete from t_r_m_mids where t_role_id = #{roleID}")
    void deleteRoleMenuList(Role role);

    @Insert("<script>" +
            "insert into t_r_m_mids" +
            "(t_role_id,t_menu_id)" +
            "values" +
            "<foreach collection ='list' item='item' separator=',' open=' ' close=' '>" +
            "(#{item.roleID},#{item.id})" +
            "</foreach>" +
            "</script>")
    void insertRoleMenuList(List<Role> list);

    @Insert("insert into t_roles" +
            "(r_name)" +
            "values" +
            "(#{roleName})")
    void insertRole(Role role);

    @Delete("delete from t_roles where r_id = #{roleID}")
    void delectRoleInfoByID(Role role);

    @Delete("delete from t_r_m_mids where t_role_id = #{roleID}")
    void deleteRoleMenuMappingInfoByID(Role role);

    @Delete("delete from t_u_r_mids where t_role_id = #{roleID}")
    void deleteUserRoleMappingInfoByID(Role role);

    @Delete("delete from t_u_r_mids where t_user_id = #{userID}")
    void deleteRoleList(Role role);


    @Insert("<script>" +
            "insert into t_u_r_mids" +
            "(t_role_id,t_user_id)" +
            "values" +
            "<foreach collection ='list' item='item' separator=',' open=' ' close=' '>" +
            "(#{item.roleID},#{item.userID})" +
            "</foreach>" +
            "</script>")
    void insertRoleList(List<Role> list);
}
