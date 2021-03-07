package com.rummykhan.jre.jreknowledgeconsole.properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PropertiesManagerImplTest {

    @Autowired
    private PropertiesManagerImpl propertiesManager;

    @BeforeEach
    void init(){
        System.out.println("Hello init");
    }

    @Test
    void testGoogleApiKeyIsNotNull() {
        assertThat(this.propertiesManager.getGoogleApiKey()).isNotNull();
    }

    @Test
    void testFilePathIsNotNull() {
        assertThat(this.propertiesManager.getJreKnowledgeFile()).isNotNull();
    }
}