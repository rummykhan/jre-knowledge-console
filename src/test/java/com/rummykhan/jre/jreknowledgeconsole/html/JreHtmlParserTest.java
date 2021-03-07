package com.rummykhan.jre.jreknowledgeconsole.html;

import com.rummykhan.jre.jreknowledgeconsole.JreKnowledgeConsoleTest;
import com.rummykhan.jre.jreknowledgeconsole.data.JreKnowledgeObject;
import com.rummykhan.jre.jreknowledgeconsole.html.parsers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JreHtmlParserTest extends JreKnowledgeConsoleTest {
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

    @Autowired
    private HtmlParser jreHtmlParser;

    private static final String jreHtmlValidString = "<div id=\"root\">\n" +
            "    <div class=\"_058ab7fd8460d89f4d140956739de083-scss\">\n" +
            "        <hr class=\"_4a554a2011f863554eb38d0dd9550c7d-scss\" aria-hidden=\"true\">\n" +
            "        <div class=\"_9a88f05b77a7b0fe7d5643f856cf9ecd-scss _887f843b27d4fe2cfdd1c824eda21929-scss\"\n" +
            "            data-testid=\"episode-0\" draggable=\"true\">\n" +
            "            <div class=\"_1b1ab862f4676405d017c4ebb029f88b-scss\">\n" +
            "                <div class=\"_25e5602352fb5e42b81fb8ee3cbaabe6-scss _8850d6075ade8f2e20120cb32ce07a9c-scss\"\n" +
            "                    style=\"width: 112px; height: 112px;\"><img aria-hidden=\"true\" draggable=\"false\" loading=\"lazy\"\n" +
            "                        src=\"https://i.scdn.co/image/ab6765630000f68d0f61ce3339425012977d4b82\"\n" +
            "                        data-testid=\"entity-image\" alt=\"#1613 - Ayaan Hirsi Ali\"\n" +
            "                        class=\"_64acb0e26fe0d9dff68a0e9725b2a920-scss eae5aabff7beab294ee900c0a1928b4c-scss undefined _22e2c5819bd02ec41b9f3c3acae3dfbf-scss\"\n" +
            "                        srcset=\"https://i.scdn.co/image/ab6765630000f68d0f61ce3339425012977d4b82 32w, https://i.scdn.co/image/ab6765630000f68d0f61ce3339425012977d4b82 64w, https://i.scdn.co/image/ab67656300005f1f0f61ce3339425012977d4b82 150w, https://i.scdn.co/image/ab67656300005f1f0f61ce3339425012977d4b82 300w, https://i.scdn.co/image/ab6765630000ba8a0f61ce3339425012977d4b82 320w, https://i.scdn.co/image/ab6765630000ba8a0f61ce3339425012977d4b82 640w, https://i.scdn.co/image/ab6765630000ba8a0f61ce3339425012977d4b82 320w, https://i.scdn.co/image/ab6765630000ba8a0f61ce3339425012977d4b82 640w\">\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"_45d6ceea63731e489eef8e6cc6286d37-scss\"><a class=\"a8cadbef66ce7f7701b7095ea51caece-scss\"\n" +
            "                    href=\"/episode/0yA586XjDwo2eKSYj01ziZ\">\n" +
            "                    <h4 class=\"e20f017648be9fc9f1cc86c0567fd221-scss _3957b7dd066dbbba6a311b40a427c59f-scss\" as=\"h4\">\n" +
            "                        #1613 - Ayaan Hirsi Ali</h4>\n" +
            "                </a>\n" +
            "                <div class=\"_381ffdf6e5b2b35454daa7bf4f11877c-scss\"><span aria-label=\"Explicit\"\n" +
            "                        class=\"_94c80de399d6a1146750abccf661f480-scss\">E</span></div>\n" +
            "            </div>\n" +
            "            <div class=\"_7f876010cdff5dbc34202ef75146493d-scss\">\n" +
            "                <p class=\"_5c2d9f29c1e5137c8dce5adafd97b1d2-scss f3fc214b257ae2f1d43d4c594a94497f-scss\" as=\"p\">Ayaan\n" +
            "                    Hirsi Ali is a human rights activist and author of the new book \"Prey: Immigration, Islam, and the\n" +
            "                    Erosion of Women's Rights.\" </p>\n" +
            "            </div>\n" +
            "            <div class=\"_5f7e8473235abc526230bfd1b2d86721-scss\">\n" +
            "                <div class=\"_19f7d100ce902c02fd58e2c9a5755ce2-scss\">\n" +
            "                    <p class=\"_0fa4f9931fd25a2f98c0e223f7a672eb-scss f3fc214b257ae2f1d43d4c594a94497f-scss\" as=\"p\">Mar 2\n" +
            "                    </p>\n" +
            "                    <p class=\"_0fa4f9931fd25a2f98c0e223f7a672eb-scss f3fc214b257ae2f1d43d4c594a94497f-scss\" as=\"p\">198\n" +
            "                        min</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"f2192a6c567c4a30871dc4a0c735f02b-scss\"><button\n" +
            "                    class=\"fd654b596ab419b9b83133bf5991fedb-scss _0171dc68e3fc4f745978eeca27256455-scss\"\n" +
            "                    aria-label=\"Share\" aria-hidden=\"false\" tabindex=\"0\" title=\"Share\" style=\"--size:24px;\"><svg\n" +
            "                        role=\"img\" focusable=\"false\" height=\"24\" width=\"24\" viewBox=\"0 0 24 24\"\n" +
            "                        class=\"Svg-sc-1usfroi-0 jUuLJy\">\n" +
            "                        <polyline points=\"8 7 12 3 16 7\" fill=\"none\" stroke=\"#181818\"></polyline>\n" +
            "                        <line x1=\"12\" y1=\"16\" x2=\"12\" y2=\"3\" fill=\"none\" stroke=\"#181818\"></line>\n" +
            "                        <polyline points=\"16 10.5 19.5 10.5 19.5 21.5 4.5 21.5 4.5 10.5 8 10.5\" fill=\"none\"\n" +
            "                            stroke=\"#181818\"></polyline>\n" +
            "                    </svg></button><button type=\"button\" aria-haspopup=\"menu\" aria-label=\"More\"\n" +
            "                    class=\"_605821ce181f6de6632eabd6a46377fb-scss\" title=\"More\"><svg role=\"img\" height=\"32\" width=\"32\"\n" +
            "                        viewBox=\"0 0 32 32\" class=\"Svg-ulyrgf-0 hJgLcF\">\n" +
            "                        <path\n" +
            "                            d=\"M5.998 13.999A2 2 0 105.999 18 2 2 0 005.998 14zm10.001 0A2 2 0 1016 18 2 2 0 0016 14zm10.001 0A2 2 0 1026.001 18 2 2 0 0026 14z\">\n" +
            "                        </path>\n" +
            "                    </svg></button></div>\n" +
            "            <div class=\"_310678f54aa2a66acb4a670536379ced-scss\"><button\n" +
            "                    class=\"_8e7d398e09c25b24232d92aac8a15a81-scss _4784fccf22dae0a2cc7c6c832914592d-scss\"\n" +
            "                    aria-label=\"Play\" data-testid=\"play-button\" title=\"Play\" style=\"--size:32px;\"><svg height=\"16\"\n" +
            "                        role=\"img\" width=\"16\" viewBox=\"0 0 24 24\" aria-hidden=\"true\">\n" +
            "                        <polygon points=\"21.57 12 5.98 3 5.98 21 21.57 12\" fill=\"currentColor\"></polygon>\n" +
            "                    </svg></button></div>\n" +
            "        </div>\n" +
            "    </div>" +
            "</div>";

    @Test
    public void testImageParserIsNotNull() {
        Assertions.assertNotNull(this.imageParser);
    }

    @Test
    public void testTitleParserIsNotNull() {
        Assertions.assertNotNull(this.titleParser);
    }

    @Test
    public void testEpisodeParserIsNotNull() {
        Assertions.assertNotNull(this.episodeParser);
    }

    @Test
    public void testDescriptionParserIsNotNull() {
        Assertions.assertNotNull(this.descriptionParser);
    }

    @Test
    public void testDateParserIsNotNull() {
        Assertions.assertNotNull(this.dateParser);
    }

    @Test
    public void testDurationParserIsNotNull() {
        Assertions.assertNotNull(this.durationParser);
    }

    @Test
    public void testJreHtmlParserIsNotNull() {
        Assertions.assertNotNull(this.jreHtmlParser);
    }

    @Test
    public void testParseStringReturnsJreKnowledgeObjectWhenStringIsValid() {
        List<JreKnowledgeObject> objectList = this.jreHtmlParser.parse(jreHtmlValidString);

        Assertions.assertNotNull(objectList);
        Assertions.assertEquals(objectList.size(), 1);
        assertThat(objectList.get(0)).isInstanceOf(JreKnowledgeObject.class);
    }
}