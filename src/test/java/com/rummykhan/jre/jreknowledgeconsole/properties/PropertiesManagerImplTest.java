package com.rummykhan.jre.jreknowledgeconsole.properties;

import com.rummykhan.jre.jreknowledgeconsole.JreKnowledgeConsoleTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PropertiesManagerImplTest extends JreKnowledgeConsoleTest {

    @Autowired
    private PropertiesManagerImpl propertiesManager;

    @BeforeEach
    void init() {
        System.out.println("Hello init");
    }

    @Test
    void testGoogleApiKeyIsNotNull() {
        Assertions.assertNotNull(this.propertiesManager.getGoogleApiKey());
    }

    @Test
    void testFilePathIsNotNull() {
        Assertions.assertNotNull(this.propertiesManager.getJreKnowledgeFile());
    }
}