package com.rummykhan.jre.jreknowledgeconsole.html;

import com.rummykhan.jre.jreknowledgeconsole.data.JreKnowledgeObject;
import com.rummykhan.jre.jreknowledgeconsole.html.parsers.*;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JreHtmlParser implements HtmlParser {

    @Autowired
    private ImageParser imageParser;

    @Autowired
    private TitleParser titleParser;

    @Autowired
    private EpisodeParser episodeParser;

    @Autowired
    private DescriptionParser descriptionParser;

    @Autowired
    private DateParser dateParser;

    @Autowired
    private DurationParser durationParser;

    @Override
    public List<JreKnowledgeObject> parse(String html) {
        Document document = this.parseHtmlToDocument(html);

        Element element = document.selectFirst("div#root");

        log.info("Element: {}, ", element.children().size());

        return this.parseChildren(element);
    }

    public Document parseHtmlToDocument(String html) {
        return Jsoup.parse(html);
    }

    public List<JreKnowledgeObject> parseChildren(Element element) {

        List<JreKnowledgeObject> objects = new ArrayList<>();

        for (Element childElement : element.children()) {

            JreKnowledgeObject object = null;

            try {
                object = this.parseChild(childElement);
            } catch (Exception e) {
                continue;
            }

            if (object == null) {
                continue;
            }

            objects.add(object);
        }

        return objects;
    }

    public JreKnowledgeObject parseChild(Element childElement) {

        JreKnowledgeObject jreKnowledgeObject = new JreKnowledgeObject();

        Element imageTag = childElement.selectFirst("img");
        jreKnowledgeObject.setImage(this.imageParser.parse(imageTag));

        Element h4Title = childElement.selectFirst("h4");
        jreKnowledgeObject.setTitle(this.titleParser.parse(h4Title));

        Element episodeLink = childElement.selectFirst("a");
        jreKnowledgeObject.setEpisodeLink(this.episodeParser.parse(episodeLink));

        List<Element> pTags = childElement.select("p");

        jreKnowledgeObject.setDescription(this.descriptionParser.parse(pTags));
        jreKnowledgeObject.setDate(this.dateParser.parse(pTags));
        jreKnowledgeObject.setDuration(this.durationParser.parse(pTags));

        return jreKnowledgeObject;
    }


}
