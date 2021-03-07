package com.rummykhan.jre.jreknowledgeconsole.data;

import com.rummykhan.jre.jreknowledgeconsole.models.JreEpisode;
import lombok.Data;

@Data
public class JreKnowledgeObject {
    private String title;
    private String description;
    private String image;
    private String date;
    private String duration;
    private String episodeLink;


    public static JreEpisode toJreEpisode(JreKnowledgeObject knowledgeObject) {
        JreEpisode jreEpisode = new JreEpisode();

        jreEpisode.setTitle(knowledgeObject.getTitle());
        jreEpisode.setDescription(knowledgeObject.getDescription());
        jreEpisode.setImage(knowledgeObject.getImage());
        jreEpisode.setDate(knowledgeObject.getDate());
        jreEpisode.setDuration(knowledgeObject.getDuration());

        return jreEpisode;
    }
}
