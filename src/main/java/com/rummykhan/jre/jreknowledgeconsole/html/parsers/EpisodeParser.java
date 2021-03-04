package com.rummykhan.jre.jreknowledgeconsole.html.parsers;

import lombok.NonNull;
import org.jsoup.nodes.Element;

public class EpisodeParser {

    public String parse(@NonNull Element episodeElement) {
        return episodeElement.attr("href").trim();
    }
}
