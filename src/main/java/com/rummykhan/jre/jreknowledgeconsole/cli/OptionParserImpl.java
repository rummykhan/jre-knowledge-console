package com.rummykhan.jre.jreknowledgeconsole.cli;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

@Slf4j
public class OptionParserImpl implements OptionParser {

    @Override
    public CommandLine parse(Options options, String[] args) {
        CommandLineParser parser = new DefaultParser();

        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            log.error("Parse exception: {}", e.getMessage());
        }

        return null;
    }
}
