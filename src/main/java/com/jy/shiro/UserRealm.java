package com.jy.shiro;

import com.jy.model.user.User;
import com.jy.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        Set<String> roleSet = new HashSet<>();
        roleSet.add("超级管理员");
        //设置角色列表
        simpleAuthorizationInfo.setRoles(roleSet);

        Set<String> permSet = new HashSet<>();
        permSet.add("book:delete");
        //设置权限列表
        simpleAuthorizationInfo.setStringPermissions(permSet);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //登陆（认证）
        System.out.println("用户来登陆");
        System.out.println(getName());
        String userAccount = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        User u = new User();
        u.setUserAccount(userAccount);
        u.setUserPwd(userPwd);
        Map<String, Object> map = userService.login(u);

        if (map.get("code").toString().equals("1")) {
            //登陆成功
            User user = (User) map.get("userInfo");
            return new SimpleAuthenticationInfo(
                    user,
                    user.getUserPwd(),
                    ByteSource.Util.bytes(user.getUserAccount()),
                    getName()
            );
        } else {
            //用户名密码错误
            return null;
        }

    }
}
