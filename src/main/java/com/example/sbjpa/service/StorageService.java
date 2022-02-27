package com.example.sbjpa.service;

import java.io.File;

import com.example.sbjpa.model.Board;
import com.example.sbjpa.model.Storage;
import com.example.sbjpa.repository.StorageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Transactional
    public void createFile(Board lastBoard, MultipartFile[] file) {
        try {
            // https://goodteacher.tistory.com/351
            // https://velog.io/@pyo-sh/Spring-Boot-파일이미지-업로드-구현하기
            if (file[0].getSize() != 0) {
                for (int i = 0; i < file.length; i++) {

                    // System.out.println("file name : " + file[i].getOriginalFilename());
                    // System.out.println("file size : " + file[i].getSize());

                    String absolutePath = new File("").getAbsolutePath() + "\\";
                    // System.out.println("absolutePath : " + absolutePath);

                    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                    // String currentDate = simpleDateFormat.format(new Date());
                    // System.out.println("currentDate : " + currentDate);
                    // System.out.println("nanoTime : " + System.nanoTime());
                    // System.out.println("ctm : " + System.currentTimeMillis());

                    long ctm = System.currentTimeMillis();

                    String pathDir = "uploads/post/" + lastBoard.getId() + "/" + ctm;

                    File fileDir = new File(pathDir);
                    if (!fileDir.exists()) {
                        fileDir.mkdirs();
                    }

                    String filename = file[i].getOriginalFilename();
                    long size = file[i].getSize();

                    File newFile = new File(absolutePath + "/" + pathDir + "/" + filename);

                    file[i].transferTo(newFile);

                    Storage storage = new Storage();

                    storage.setFilename(filename);
                    storage.setSize(size);
                    storage.setPath(pathDir + "/" + filename);

                    storage.setBoard(lastBoard);

                    storageRepository.save(storage);
                }
            } else {
                System.out.println("파일 첨부 안함");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
