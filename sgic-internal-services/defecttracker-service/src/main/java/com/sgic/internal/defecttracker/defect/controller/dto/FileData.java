package com.sgic.internal.defecttracker.defect.controller.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import org.springframework.data.annotation.Id;

public class FileData {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private String fileName;

    private String fileType;

	@Lob
    private byte[] data;
	private Long defectId;
	
	public Long getDefectId() {
		return defectId;
	}

	public void setDefectId(Long defectId) {
		this.defectId = defectId;
	}

	public FileData() {

    }

    public FileData(String fileName, String fileType, byte[] data, Long defectId) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.defectId = defectId;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
   

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}