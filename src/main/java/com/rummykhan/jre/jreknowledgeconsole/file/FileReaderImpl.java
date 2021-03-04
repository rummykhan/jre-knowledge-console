package com.rummykhan.jre.jreknowledgeconsole.file;

import lombok.NonNull;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileReaderImpl implements FileReader {

    @Override
    public String readFile(@NonNull String filePath) throws IOException {
        return inputStreamToString(readFileAsResource(filePath));
    }

    private Resource readFileAsResource(String filePath) {
        return new ClassPathResource(filePath);
    }


    private String inputStreamToString(Resource fileResource) throws IOException {
        File resource = fileResource.getFile();
        return new String(Files.readAllBytes(resource.toPath()));
    }
}
