package com.rummykhan.jre.jreknowledgeconsole.repositories;

import com.rummykhan.jre.jreknowledgeconsole.JreKnowledgeConsoleTest;
import com.rummykhan.jre.jreknowledgeconsole.entities.JreEpisode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class JreEpisodeRepositoryTest extends JreKnowledgeConsoleTest {

    @Autowired
    private JreEpisodeRepository jreEpisodeRepository;

    private String idThatExist = "";

    private void addDummyRecord() {

        JreEpisode episode = new JreEpisode();
        episode.setTitle("Some title");
        episode.setDescription("Some description");
        episode.setImage("Some image here");
        episode.setDate("March 2020");
        episode.setDuration("10 minute");

        episode = this.jreEpisodeRepository.save(episode);

        this.idThatExist = episode.getId();
    }

    private void cleanUp() throws Exception {
        this.jreEpisodeRepository.deleteById(this.idThatExist);
    }


    @Test
    public void testJreEpisodeRepositoryIsNotNull() {
        Assertions.assertNotNull(this.jreEpisodeRepository);
    }

    @Test
    public void testJreRepositoryCanFindRecordById() throws Exception {
        addDummyRecord();
        Assertions.assertNotNull(this.jreEpisodeRepository.findById(this.idThatExist));
        cleanUp();
    }
}