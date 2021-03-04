package com.rummykhan.jre.jreknowledgeconsole.html.parsers;

import lombok.NonNull;
import org.jsoup.nodes.Element;

public class TitleParser {

    public String parse(@NonNull Element h4Element) {
        return h4Element.text().trim();
    }
}
