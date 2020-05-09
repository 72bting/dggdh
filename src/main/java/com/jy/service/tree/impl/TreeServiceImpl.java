package com.jy.service.tree.impl;

import com.jy.mapper.tree.TreeMapper;
import com.jy.model.role.Role;
import com.jy.model.tree.Tree;
import com.jy.service.tree.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> selectMenuListTree(Tree tree) {
        List<Tree> list = treeMapper.selectMenuListTree(tree);
        if (null != list && 0 < list.size()) {
            //遍历一级菜单
            for (Tree tr1 : list) {
                Tree t = new Tree();
                t.setPid(tr1.getId());
                List<Tree> children = selectMenuListTree(t);
                //判断子列表非空
                if (null != children && 0 < children.size()) {
                    //把子列表放进父级菜单中
                    tr1.setChildren(children);
                }
            }
        }
        return list;
    }

    @Override
    public void insertTree(Tree tree) {
        treeMapper.insertTree(tree);
    }

    @Override
    public void deleteTreeNodeByID(Tree tree) {
        treeMapper.deleteTreeNodeByID(tree);
    }

    @Override
    public Tree selectTreeByID(Tree tree) {
        return treeMapper.selectTreeByID(tree);
    }

    @Override
    public void updateTreeByID(Tree tree) {
        treeMapper.updateTreeByID(tree);
    }

    @Override
    public List<Tree> selectRoleMenuList(Role role) {
        List<Tree> list = treeMapper.selectRoleMenuList(role);
        return list;
    }
}
