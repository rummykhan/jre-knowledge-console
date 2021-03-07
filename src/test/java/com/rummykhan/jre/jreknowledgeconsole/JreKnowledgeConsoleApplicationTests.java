package com.rummykhan.jre.jreknowledgeconsole;

import com.rummykhan.jre.jreknowledgeconsole.file.FileReader;
import com.rummykhan.jre.jreknowledgeconsole.html.HtmlParser;
import com.rummykhan.jre.jreknowledgeconsole.properties.PropertiesManagerImpl;
import com.rummykhan.jre.jreknowledgeconsole.repositories.JreEpisodeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class JreKnowledgeConsoleApplicationTests extends JreKnowledgeConsoleTest {

    @Autowired
    public HtmlParser htmlParser;

    @Autowired
    public PropertiesManagerImpl propertiesManager;

    @Autowired
    public FileReader fileReader;

    @Autowired
    private JreEpisodeRepository jreEpisodeRepository;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("I;ll be executed only once for all test cases");
    }

    @Test
    void testHtmlParserIsNotNull() {
        Assertions.assertNotNull(this.htmlParser);
    }

    @Test
    void testPropertyManagerIsNotNull() {
        Assertions.assertNotNull(this.propertiesManager);
    }

    @Test
    void testFileReaderIsNotNull() {
        Assertions.assertNotNull(this.fileReader);
    }

    @Test
    void testJreEpisodeRepositoryIsNotNull() {
        Assertions.assertNotNull(this.jreEpisodeRepository);
    }
}
