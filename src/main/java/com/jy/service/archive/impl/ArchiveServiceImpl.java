package com.jy.service.archive.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jy.mapper.archive.ArchiveMapper;
import com.jy.model.archive.Archive;
import com.jy.service.archive.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ArchiveMapper archiveMapper;

    @Override
    public Map<String, Object> selectArchiveList(Archive archive) {
        Map<String, Object> map = new HashMap();
        //开启分页
        PageHelper.startPage(archive.getPage(), archive.getLimit());
        List<Archive> list = archiveMapper.selectArchiveList(archive);
        //转化
        Page page = (Page) list;
        //获取总条数
        long total = page.getTotal();

        map.put("code", 0);
        map.put("msg","");
        map.put("data", list);
        map.put("count", total);
        return map;
    }

    @Override
    public void insertArchive(Archive archive) {
        archiveMapper.insertArchive(archive);
    }

    @Override
    public void deleteOneArchive(Archive archive) {
        archiveMapper.deleteOneArchive(archive);
    }

    @Override
    public Archive selectArchiveByID(Archive archive) {
        return archiveMapper.selectArchiveByID(archive);
    }

    @Override
    public void updateArchive(Archive archive) {
        archiveMapper.updateArchive(archive);
    }

    @Override
    public void deleteArchives(Archive archive) {
        archiveMapper.deleteArchives(archive);
    }

}
