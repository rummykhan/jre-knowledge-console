package com.rummykhan.jre.jreknowledgeconsole.html.parsers;

import lombok.NonNull;
import org.jsoup.nodes.Element;

import java.util.List;

public class DurationParser {

    public String parse(@NonNull List<Element> elements) {

        if (elements.size() < 3) {
            return null;
        }

        return elements.get(2).text().trim();
    }
}
