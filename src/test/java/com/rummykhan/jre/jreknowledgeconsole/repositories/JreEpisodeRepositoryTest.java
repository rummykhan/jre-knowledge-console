package com.rummykhan.jre.jreknowledgeconsole.repositories;

import com.rummykhan.jre.jreknowledgeconsole.models.JreEpisode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class JreEpisodeRepositoryTest {

    @Autowired
    private JreEpisodeRepository jreEpisodeRepository;

    private String idThatExist = "";

    private void addDummyRecord() {
        JreEpisode jreEpisode = this.jreEpisodeRepository.save(new JreEpisode());

        this.idThatExist = jreEpisode.getId();
    }

    private void cleanUp() throws Exception {
        this.jreEpisodeRepository.deleteById(this.idThatExist);
    }


    @Test
    public void testJreEpisodeRepositoryIsNotNull() {
        Assertions.assertThat(this.jreEpisodeRepository).isNotNull();
    }

    @Test
    public void testJreRepositoryCanFindRecordById() throws Exception {
        addDummyRecord();
        Assertions.assertThat(this.jreEpisodeRepository.findById(this.idThatExist)).isNotNull();
        cleanUp();
    }
}