package com.jy.controller.tree;

import com.jy.model.role.Role;
import com.jy.model.tree.Tree;
import com.jy.service.menu.MenuService;
import com.jy.service.tree.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("tree/toList")
    String toMenuList() {
        return "tree/list";
    }

    @RequestMapping("tree/tree")
    @ResponseBody
    List<Tree> selectMenuListTree(Tree tree) {
        List<Tree> list = treeService.selectMenuListTree(tree);
        return list;
    }

    @RequestMapping("tree/toAdd")
    String toAddTree(Tree tree, ModelMap mm) {
        mm.addAttribute("tree", tree);
        return "tree/add";
    }

    @RequestMapping("tree/insert")
    @ResponseBody
    Tree insertTree(Tree tree){
        treeService.insertTree(tree);
        return tree;
    }

    @RequestMapping("tree/delete")
    @ResponseBody
    String delTreeNodeByID(Tree tree){
        treeService.deleteTreeNodeByID(tree);
        return "{}";
    }

    @RequestMapping("tree/toEdit")
    String toEditTree(Tree tree, ModelMap mm) {
        Tree t = treeService.selectTreeByID(tree);
        mm.addAttribute("tree", t);
        return "tree/edit";
    }

    @RequestMapping("tree/update")
    @ResponseBody
    Tree updateTree(Tree tree){
        treeService.updateTreeByID(tree);
        return tree;
    }

    @RequestMapping("tree/setupTree")
    @ResponseBody
    List<Tree> selectRoleMenuList(Role role){
        List<Tree> list = treeService.selectRoleMenuList(role);
            return list;
    }


}
