package com.jy.service.tree;

import com.jy.model.role.Role;
import com.jy.model.tree.Tree;

import java.util.List;

public interface TreeService {

    List<Tree> selectMenuListTree(Tree tree);

    void insertTree(Tree tree);

    void deleteTreeNodeByID(Tree tree);

    Tree selectTreeByID(Tree tree);

    void updateTreeByID(Tree tree);

    List<Tree> selectRoleMenuList(Role role);
}
