package com.rummykhan.jre.jreknowledgeconsole.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
@Configuration
@PropertySource("classpath:pom.properties")
public class PropertiesManagerImpl {

    @Value("${googleApiKey}")
    private String googleApiKey;

    @Value("${jre-knowledge.file}")
    private String jreKnowledgeFile;
}
