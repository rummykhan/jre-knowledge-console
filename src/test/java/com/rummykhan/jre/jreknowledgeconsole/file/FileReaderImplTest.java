package com.rummykhan.jre.jreknowledgeconsole.file;

import com.rummykhan.jre.jreknowledgeconsole.JreKnowledgeConsoleTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

class FileReaderImplTest extends JreKnowledgeConsoleTest {

    private static final String file_that_exist = "storage/joe-rogan-spotify.html";
    private static final String file_that_donot_exist = "storage/joe-rogan-spotify-donot-exist.html";

    @Autowired
    private FileReader fileReader;

    @Test
    public void testFileReaderISNotNull() {
        Assertions.assertThat(this.fileReader).isNotNull();
    }

    @Test
    public void testFileReaderCanReadFileThatExist() throws IOException {

        Assertions.assertThat(this.fileReader.readFile(file_that_exist))
                .isNotNull();
    }

    @Test
    public void testFileReaderThrowExceptionAtFileThatDoesntExist() {

        try {
            Assertions.assertThat(this.fileReader.readFile(file_that_donot_exist))
                    .isNotNull();
        } catch (IOException exception) {
            Assertions.assertThat(exception).isInstanceOf(IOException.class);
        }
    }
}