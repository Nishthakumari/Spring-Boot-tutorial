package com.nishtha.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nishtha.restapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must conatin file");

            }

            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content are allowed");
            }

            boolean f = fileUploadHelper.uploadFile(file);
            f = true;

            if (f) {
                return ResponseEntity.ok("File is successfully uploaded");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somethinng went wrong. Try again !!");

    }
}
