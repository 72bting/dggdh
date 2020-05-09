package com.jy.mapper.user;

import com.jy.model.user.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User login(User user);

    List<User> selectUserList(User user);

    void deleteUser(User user);

    void deleteUserRoleMappingByID(User user);

    List<User> selectUserAccount(User user);

    void insertUserInfo(User user);
}
