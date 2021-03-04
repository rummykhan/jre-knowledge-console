package com.rummykhan.jre.jreknowledgeconsole;

import com.rummykhan.jre.jreknowledgeconsole.cli.OptionManager;
import com.rummykhan.jre.jreknowledgeconsole.cli.OptionParser;
import com.rummykhan.jre.jreknowledgeconsole.data.JreKnowledgeObject;
import com.rummykhan.jre.jreknowledgeconsole.file.FileReader;
import com.rummykhan.jre.jreknowledgeconsole.html.HtmlParser;
import com.rummykhan.jre.jreknowledgeconsole.models.Test;
import com.rummykhan.jre.jreknowledgeconsole.properties.PropertiesManagerImpl;
import com.rummykhan.jre.jreknowledgeconsole.repositories.TestRepository;
import com.rummykhan.jre.jreknowledgeconsole.router.Router;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringBootApplication
public class JreKnowledgeConsoleApplication implements CommandLineRunner {

    @Autowired
    public OptionManager optionManager;

    @Autowired
    public OptionParser optionParser;

    @Autowired
    public Router router;

    @Autowired
    public HtmlParser htmlParser;

    @Autowired
    public PropertiesManagerImpl propertiesManager;

    @Autowired
    public FileReader fileReader;

    @Autowired
    private TestRepository testRepository;

    public static void main(String[] args) {

        log.info("JreKnowledgeConsoleApplication -> main()");
        SpringApplication.run(JreKnowledgeConsoleApplication.class, args);
    }

    public CommandLine getCommandLine(String[] args) {
        return this.optionParser.parse(this.optionManager.getCliOptions(), args);
    }

    @Override
    public void run(String[] args) throws IOException {
        // this.router.route(this.getCommandLine(args));

        log.info("Application -> run()");
        String fileContents = this.fileReader.readFile(this.propertiesManager.getJreKnowledgeFile());

        log.info("File content read successful, size: {}", fileContents.length());

        List<JreKnowledgeObject> objects = this.htmlParser.parse(fileContents);

        log.info("Got episodes : {}", objects.size());

        for (Test test : this.testRepository.findAll()) {
            log.info("Test: {}", test);
        }

    }

}
