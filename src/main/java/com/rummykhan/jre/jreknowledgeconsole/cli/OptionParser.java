package com.rummykhan.jre.jreknowledgeconsole.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public interface OptionParser {

    public CommandLine parse(Options options, String[] args);
}
