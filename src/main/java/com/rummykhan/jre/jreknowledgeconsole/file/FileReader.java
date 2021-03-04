package com.rummykhan.jre.jreknowledgeconsole.file;

import lombok.NonNull;

import java.io.IOException;

public interface FileReader {

    public String readFile(@NonNull String filePath) throws IOException;
}
