package com.jy.controller.archive;

import com.jy.model.archive.Archive;
import com.jy.service.archive.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @RequestMapping("/archives/toList")
    String toArchiveList(){
        return "archive/list";
    }

    @RequestMapping("archive/list")
    @ResponseBody
    Map<String, Object> selectArchiveList(Archive archive) {
        Map<String, Object> map = archiveService.selectArchiveList(archive);
        return map;
    }

    @RequestMapping("archive/toAddPage")
    String toAddArchivePage(Archive archive){
        return "archive/add";
    }

    @RequestMapping("archive/insert")
    @ResponseBody
    String addArchive(Archive archive){
        archiveService.insertArchive(archive);
        return "{}";
    }

    @RequestMapping("archive/deleteOne")
    @ResponseBody
    String deleteArchive(Archive archive){
        archiveService.deleteOneArchive(archive);
        return "{}";
    }

    @RequestMapping("archive/edit")
    String selectArchiveByID(Archive archive, ModelMap mm){
       Archive archive1 =  archiveService.selectArchiveByID(archive);
        mm.addAttribute("archive",archive1);
        return "archive/edit";
    }

    @RequestMapping("archive/update")
    @ResponseBody
    String updateArchive(Archive archive){
        archiveService.updateArchive(archive);
        return "{}";
    }

    @RequestMapping("archive/deleteAll")
    @ResponseBody
    String deleteArchives(Archive archive){
        archiveService.deleteArchives(archive);
        return "{}";
    }

}
