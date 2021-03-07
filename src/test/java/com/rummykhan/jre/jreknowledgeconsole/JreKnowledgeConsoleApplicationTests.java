package com.rummykhan.jre.jreknowledgeconsole;

import com.rummykhan.jre.jreknowledgeconsole.file.FileReader;
import com.rummykhan.jre.jreknowledgeconsole.html.HtmlParser;
import com.rummykhan.jre.jreknowledgeconsole.properties.PropertiesManagerImpl;
import com.rummykhan.jre.jreknowledgeconsole.repositories.JreEpisodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class JreKnowledgeConsoleApplicationTests {

    @Autowired
    public HtmlParser htmlParser;

    @Autowired
    public PropertiesManagerImpl propertiesManager;

    @Autowired
    public FileReader fileReader;

    @Autowired
    private JreEpisodeRepository jreEpisodeRepository;


    @Test
    void testHtmlParserIsNotNull() {
        assertThat(this.htmlParser).isNotNull();
    }

    @Test
    void testPropertyManagerIsNotNull() {
        assertThat(this.propertiesManager).isNotNull();
    }

    @Test
    void testFileReaderIsNotNull() {
        assertThat(this.fileReader).isNotNull();
    }

    @Test
    void testJreEpisodeRepositoryIsNotNull() {
        assertThat(this.jreEpisodeRepository).isNotNull();
    }

    @Test
    void testAssertStringNotNull() {
        assertThat("this is a string").isNotNull();
    }
}
