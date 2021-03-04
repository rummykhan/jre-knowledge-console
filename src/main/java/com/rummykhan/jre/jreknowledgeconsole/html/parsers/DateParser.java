package com.rummykhan.jre.jreknowledgeconsole.html.parsers;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;

import java.util.List;

@Slf4j
public class DateParser {

    public String parse(@NonNull List<Element> elements) {

        if (elements.size() < 2) {
            return null;
        }

        return elements.get(1).text().trim();
    }
}
