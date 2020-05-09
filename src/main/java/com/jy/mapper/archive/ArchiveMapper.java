package com.jy.mapper.archive;

import com.jy.model.archive.Archive;

import java.util.List;
import java.util.Map;

public interface ArchiveMapper {

    List<Archive> selectArchiveList(Archive archive);

    void insertArchive(Archive archive);

    void deleteOneArchive(Archive archive);

    Archive selectArchiveByID(Archive archive);

    void updateArchive(Archive archive);

    void deleteArchives(Archive archive);

}
