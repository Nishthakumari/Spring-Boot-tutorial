package com.nishtha.restapi.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public String UPLOAD_DIR = "C:\\Users\\Nishtha\\Documents\\Projects\\restapi\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile multipartFile) {

        boolean f = false;

        // try {

        // InputStream is = multipartFile.getInputStream();
        // byte[] data = new byte[is.available()];
        // is.read(data);

        // FileOutputStream fos = new FileOutputStream(
        // UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
        // fos.write(data);

        // fos.flush();
        // fos.close();

        // f = true;

        // } catch (Exception e) {
        // e.printStackTrace();

        // }

        try {
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return f;

    }
}
