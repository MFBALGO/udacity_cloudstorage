package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

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

    public List<File> getFilesForUser(int userId){
        return fileMapper.getUserid(userId);
    }

    public Integer deleteFile(Integer id){
        return fileMapper.delete(id);
    }

    public void addFile(MultipartFile multipartFile, Integer userId) throws IOException {
        File file = new File();
        file.setUserid(userId);
        file.setFilename(multipartFile.getOriginalFilename());
        file.setContenttype(multipartFile.getContentType());
        file.setFilesize("" + multipartFile.getSize());
        file.setFiledata(multipartFile.getBytes());
        fileMapper.insert(file);
    }

}
