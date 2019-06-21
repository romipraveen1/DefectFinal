package com.sgic.internal.defecttracker.defect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.DBFile;
import com.sgic.internal.defecttracker.defect.exception.FileStorageException;
import com.sgic.internal.defecttracker.defect.exception.MyFileNotFoundException;
import com.sgic.internal.defecttracker.defect.repositories.DBFileRepository;

@Service
public class FileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(DBFile dbFile) {
        // Normalize file name
        String fileName = dbFile.getFileName();
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile1 = new DBFile(fileName, dbFile.getFileType(), dbFile.getData(),dbFile.getDefectId());

            return dbFileRepository.save(dbFile1);
       
    }

    public DBFile getFile(Long fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
//    }
//    public List<DBFile> getFile(Long defectId) {
//        return dbFileRepository.findDBFileByDefectId(defectId);
//                .orElseThrow(() -> new MyFileNotFoundException("File not found with defectId " + defectId));
//    }
    }
}