package com.rummykhan.jre.jreknowledgeconsole.html;

import com.rummykhan.jre.jreknowledgeconsole.data.JreKnowledgeObject;

import java.util.List;

public interface HtmlParser {
    public List<JreKnowledgeObject> parse(String html);
}
