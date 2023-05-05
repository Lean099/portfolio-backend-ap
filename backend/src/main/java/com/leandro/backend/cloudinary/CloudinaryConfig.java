package com.leandro.backend.cloudinary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class CloudinaryConfig {
    
    @Value("${cloudinary.cloud_name}")
    private String cloud_name;
    @Value("${cloudinary.api_key}")
    private String api_key;
    @Value("${cloudinary.api_secret}")
    private String api_secret;

    public Cloudinary cloudinaryConfig() {
        Cloudinary cloudinary = null;
        Map<String, String> config = new HashMap<String, String>();
        config.put("cloud_name", cloud_name);
        config.put("api_key", api_key);
        config.put("api_secret", api_secret);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

    public Map uploadFile(String originalFilename){
        Map fileInfo = null;
        Cloudinary cloudinary = cloudinaryConfig();
        File filePath = returnFilePath();
        try {
            fileInfo = cloudinary.uploader().upload(filePath, ObjectUtils.emptyMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileInfo;
    }

    // Guardar el archivo en la carpeta
    public void writeFileToUploadFolder(byte[] fileBytes, String originalFilename){
        log.info("Entro al metodo...");
        try {
            String pathFolderAndFile = new FileSystemResource("").getFile().getAbsolutePath() + "/src/main/resources/uploads/" + originalFilename;
            log.info("Path completo: {}", pathFolderAndFile);
            Path path = Paths.get(pathFolderAndFile);
            log.info("Segundo Path: {}", path);
            Files.write(path, fileBytes);
            //Otra forma de escribir el archivo
            //FileOutputStream output = new FileOutputStream(pathFolderAndFile);
            //output.write(fileBytes);
            //output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Borrar el archivo en la carpeta
    public void deleteFileInUploadFolder(){
        try {
            String pathFolder = new FileSystemResource("").getFile().getAbsolutePath() + "/src/main/resources/uploads/";
            List<Path> filePathList = Files.walk(Paths.get(pathFolder))
                    .filter(Files::isRegularFile)
                    .filter(path -> !path.endsWith(".gitignore"))
                    .map(Path::toAbsolutePath)
                    .collect(Collectors.toList());
            filePathList.forEach(e -> {
                try {
                    Files.delete(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Devolver la ruta del archivo
    public File returnFilePath(){
        File file = null;
        try {
            String pathFolder = new FileSystemResource("").getFile().getAbsolutePath() + "/src/main/resources/uploads/";
            List<File> filePathList = Files.walk(Paths.get(pathFolder))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            file = filePathList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public void createDirUpload(){
        try{
            String pathFolder = new FileSystemResource("").getFile().getAbsolutePath() + "/src/main/resources/uploads/";
            Path dir = Paths.get(pathFolder);
            Files.createDirectory(dir);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Boolean notExistsDir(){
        Boolean exist = null;
        try{
            String pathFolder = new FileSystemResource("").getFile().getAbsolutePath() + "/src/main/resources/uploads/";
            Path dir = Paths.get(pathFolder);
            exist = Files.notExists(dir);
        }catch(Exception e){
            e.printStackTrace();
        }
        return exist;
    }

}
