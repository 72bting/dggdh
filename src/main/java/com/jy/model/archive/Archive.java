package com.jy.model.archive;

import com.jy.common.PageUtil;

import java.io.Serializable;

public class Archive extends PageUtil implements Serializable {

    private int archiveID;
    private String archiveTitle;
    private String archiveName;
    private int archiveType;
    private String archiveDateStr;
    private String archiveIDS;

    public String getArchiveIDS() {
        return archiveIDS;
    }

    public void setArchiveIDS(String archiveIDS) {
        this.archiveIDS = archiveIDS;
    }

    public int getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(int archiveID) {
        this.archiveID = archiveID;
    }

    public String getArchiveTitle() {
        return archiveTitle;
    }

    public void setArchiveTitle(String archiveTitle) {
        this.archiveTitle = archiveTitle;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public int getArchiveType() {
        return archiveType;
    }

    public void setArchiveType(int archiveType) {
        this.archiveType = archiveType;
    }

    public String getArchiveDateStr() {
        return archiveDateStr;
    }

    public void setArchiveDateStr(String archiveDateStr) {
        this.archiveDateStr = archiveDateStr;
    }
}
