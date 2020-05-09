package com.jy.service.user;

import com.jy.model.role.Role;
import com.jy.model.user.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String, Object> login(User user);

    Map<String,Object> selectUserList(User user);

    void deleteUserByID(User user);

    List<User> selectUserAccount(User user);

    Map<String,Object> insertUser(User user);
}
