package com.jy.service.user.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jy.mapper.user.UserMapper;
import com.jy.model.role.Role;
import com.jy.model.user.User;
import com.jy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(User user) {
        Map<String,Object> map =  new HashMap<>();
        //声明变量，code = 0 代表登陆失败(用户匹配失败/没有查询到这个用户)
        int code = 0;
        User u = userMapper.login(user);
        if (null != u){
            //代表登陆成功(用户匹配成功)
            code = 1;
        }
        //将查询回来的用户和状态码放进map中
        map.put("userInfo",u);
        map.put("code",code);
        return map;
    }

    @Override
    public Map<String, Object> selectUserList(User user) {
        //声明map
        Map<String, Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(user.getPage(), user.getLimit());
        //查询列表
        List<User> list = userMapper.selectUserList(user);
        //转换为Page类
        Page page = (Page) list;
        //获取总条数
        long total = page.getTotal();
        //封装数据到map中
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", list);
        map.put("count", total);
        return map;
    }

    @Override
    public void deleteUserByID(User user) {
        //删除用户表中的用户数据
        userMapper.deleteUser(user);
        //删除用户角色中间表中对应的用户数据
        userMapper.deleteUserRoleMappingByID(user);
    }

    @Override
    public List<User> selectUserAccount(User user) {
        List<User> list = userMapper.selectUserAccount(user);
        return list;
    }

    @Override
    public Map<String,Object> insertUser(User user) {
        Map<String,Object> map = new HashMap<>();
        int code = 0;
        //根据userAccount查询用户名是否存在
        List<User> list = userMapper.selectUserAccount(user);
        //判断用户名是否重复
        /** if(list == null !! 0 == list.size()){
         code = 0; 代表为空（用户名不存在）可以添加
                    flag = 0;
                    userMapper.insertUserInfo(user);
          }else{
          code = 1; 代表用户名存在 不可以添加
                    code = 1;
          } */
        if(list != null && 0 < list.size()){
            //code = 1; 代表用户名存在 不可以添加
            code = 1;
        }else{
            //code = 0; 代表为空（用户名不存在）可以添加
            code = 0;
            userMapper.insertUserInfo(user);
        }
        map.put("code",code);
        return map;
    }

}
