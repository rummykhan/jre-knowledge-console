package com.rummykhan.jre.jreknowledgeconsole.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Order(3)
class PropertiesManagerImplTest {

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