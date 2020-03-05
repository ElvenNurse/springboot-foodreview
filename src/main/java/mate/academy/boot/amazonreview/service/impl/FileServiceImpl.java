package mate.academy.boot.amazonreview.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import mate.academy.boot.amazonreview.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    private final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    @Value("${data.file.name}")
    private String initFileName;
    @Value("${data.file.url}")
    private String initFileUrl;

    @Override
    public File getInitFile() {
        try {
            return new ClassPathResource(initFileName).getFile();
        } catch (FileNotFoundException e) {
            String outputPath = "src/main/resources/" + initFileName;
            logger.info("File not found! Start downloading file from web!");
            downloadFile(initFileUrl, outputPath);
            logger.info("Successfully download file!");
            return new File(outputPath);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while getting file!", e);
        }
    }

    private void downloadFile(String outerPath, String innerPath) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(outerPath).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(innerPath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while downloading file from web!", e);
        }
    }
}
