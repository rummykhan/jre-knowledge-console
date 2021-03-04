package com.rummykhan.jre.jreknowledgeconsole.html.config;

import com.rummykhan.jre.jreknowledgeconsole.html.parsers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JreHtmlParserConfig {

    @Bean
    public ImageParser imageParser() {
        return new ImageParser();
    }

    @Bean
    public TitleParser titleParser() {
        return new TitleParser();
    }

    @Bean
    public EpisodeParser episodeParser() {
        return new EpisodeParser();
    }

    @Bean
    public DescriptionParser descriptionParser() {
        return new DescriptionParser();
    }

    @Bean
    public DateParser dateParser() {
        return new DateParser();
    }

    @Bean
    public DurationParser durationParser() {
        return new DurationParser();
    }

}
