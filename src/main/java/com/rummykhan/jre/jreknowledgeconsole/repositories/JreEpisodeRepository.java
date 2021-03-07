package com.rummykhan.jre.jreknowledgeconsole.repositories;

import com.rummykhan.jre.jreknowledgeconsole.entities.JreEpisode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JreEpisodeRepository extends MongoRepository<JreEpisode, String> {

    public JreEpisode findByTitle(String title);
}
