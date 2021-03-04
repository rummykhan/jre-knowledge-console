package com.rummykhan.jre.jreknowledgeconsole.models;

import com.rummykhan.jre.jreknowledgeconsole.data.JreKnowledgeObject;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "jre_episodes")
@Data
public class JreEpisode {

    @Id
    private String id;

    private String title;

    private String description;

    private String image;

    private String date;

    private String duration;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    public JreEpisode(JreKnowledgeObject knowledgeObject) {
        this.title = knowledgeObject.getTitle();
        this.description = knowledgeObject.getDescription();
        this.image = knowledgeObject.getImage();
        this.date = knowledgeObject.getDate();
        this.duration = knowledgeObject.getDuration();
    }
}
