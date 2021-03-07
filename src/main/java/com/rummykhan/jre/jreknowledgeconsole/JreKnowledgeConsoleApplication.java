package com.rummykhan.jre.jreknowledgeconsole;

import com.rummykhan.jre.jreknowledgeconsole.data.JreKnowledgeObject;
import com.rummykhan.jre.jreknowledgeconsole.file.FileReader;
import com.rummykhan.jre.jreknowledgeconsole.html.HtmlParser;
import com.rummykhan.jre.jreknowledgeconsole.entities.JreEpisode;
import com.rummykhan.jre.jreknowledgeconsole.properties.PropertiesManagerImpl;
import com.rummykhan.jre.jreknowledgeconsole.repositories.JreEpisodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableMongoAuditing
public class JreKnowledgeConsoleApplication implements CommandLineRunner {

    /*
     * Commented for the same reason commenting this line as of getCommandLine
     *
     * @Autowired
     * public OptionManager optionManager;
     *
     * @Autowired
     * public OptionParser optionParser;
     *
     * @Autowired
     * public Router router;
     */

    @Autowired
    public HtmlParser htmlParser;

    @Autowired
    public PropertiesManagerImpl propertiesManager;

    @Autowired
    public FileReader fileReader;

    @Autowired
    private JreEpisodeRepository jreEpisodeRepository;

    public static void main(String[] args) {

        log.info("JreKnowledgeConsoleApplication -> main()");
        SpringApplication.run(JreKnowledgeConsoleApplication.class, args);
    }

    /**
     * Changed my mind about using console arguments that's why commented
     * Keeping it commented as I may have to take help from here.
     * <p>
     * public CommandLine getCommandLine(String[] args) {
     * return this.optionParser.parse(this.optionManager.getCliOptions(), args);
     * }
     */

    @Override
    public void run(String[] args) throws IOException {

        // Commented for the same reason commenting this line as of getCommandLine
        // this.router.route(this.getCommandLine(args));

        log.info("Application -> run()");
        String fileContents = this.fileReader.readFile(this.propertiesManager.getJreKnowledgeFile());

        log.info("File content read successful, size: {}", fileContents.length());

        List<JreKnowledgeObject> objects = this.htmlParser.parse(fileContents);

        log.info("Got episodes : {}", objects.size());

        for (JreKnowledgeObject object : objects) {

            JreEpisode jreEpisode = this.jreEpisodeRepository.findByTitle(object.getTitle());

            if (null != jreEpisode) {
                continue;
            }

            JreEpisode insertedObject = this.jreEpisodeRepository.save(JreKnowledgeObject.toJreEpisode(object));

            log.info("Object inserted at: {}", insertedObject.getId());
        }

    }

}
