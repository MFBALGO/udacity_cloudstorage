package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Blob;

@Service
public class FileService {

    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating FileService bean");
    }

    public File findFile(Integer fileId) {
        return fileMapper.getFileId(fileId);
    }

    //incomplete
    public boolean addFile(Blob fileData, Integer userId){

    }

}
