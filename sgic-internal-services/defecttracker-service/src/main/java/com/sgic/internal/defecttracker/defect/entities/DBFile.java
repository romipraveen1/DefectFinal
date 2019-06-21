package com.sgic.internal.defecttracker.defect.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class DBFile {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
//	@ManyToOne
//	@JoinColumn(name="defectId", nullable=false)
//	private Defect defect;

	private String fileName;

    private String fileType;

    @Lob
    private byte[] data;
    private Long defectId;
 
	public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data,Long defectId) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.defectId=defectId;
    }
    
    

  


	public Long getDefectId() {
		return defectId;
	}

	public void setDefectId(Long defectId) {
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
