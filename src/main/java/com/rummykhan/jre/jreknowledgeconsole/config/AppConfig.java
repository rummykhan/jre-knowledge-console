package com.rummykhan.jre.jreknowledgeconsole.config;

import com.rummykhan.jre.jreknowledgeconsole.cli.OptionManager;
import com.rummykhan.jre.jreknowledgeconsole.cli.OptionManagerImpl;
import com.rummykhan.jre.jreknowledgeconsole.cli.OptionParser;
import com.rummykhan.jre.jreknowledgeconsole.cli.OptionParserImpl;
import com.rummykhan.jre.jreknowledgeconsole.file.FileReader;
import com.rummykhan.jre.jreknowledgeconsole.file.FileReaderImpl;
import com.rummykhan.jre.jreknowledgeconsole.html.HtmlParser;
import com.rummykhan.jre.jreknowledgeconsole.html.JreHtmlParser;
import com.rummykhan.jre.jreknowledgeconsole.properties.PropertiesManagerImpl;
import com.rummykhan.jre.jreknowledgeconsole.router.Router;
import com.rummykhan.jre.jreknowledgeconsole.router.RouterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OptionManager optionManager() {
        return new OptionManagerImpl();
    }

    @Bean
    public OptionParser optionParser() {
        return new OptionParserImpl();
    }

    @Bean
    public Router router() {
        return new RouterImpl();
    }

    @Bean
    public HtmlParser htmlParser() {
        return new JreHtmlParser();
    }

    @Bean
    public PropertiesManagerImpl propertiesManager() {
        return new PropertiesManagerImpl();
    }

    @Bean
    public FileReader fileReader() {
        return new FileReaderImpl();
    }
}
