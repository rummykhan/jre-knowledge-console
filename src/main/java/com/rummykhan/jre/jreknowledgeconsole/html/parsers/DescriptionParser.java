package com.rummykhan.jre.jreknowledgeconsole.html.parsers;

import lombok.NonNull;
import org.jsoup.nodes.Element;

import java.util.List;

public class DescriptionParser {
    public String parse(@NonNull List<Element> elements) {
        if (elements.size() < 1) {
            return null;
        }
        return elements.get(0).text().trim();
    }
}
