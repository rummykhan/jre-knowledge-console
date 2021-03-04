package com.rummykhan.jre.jreknowledgeconsole.cli;

import com.rummykhan.jre.jreknowledgeconsole.data.Option;
import org.apache.commons.cli.Options;

import java.util.List;

public interface OptionManager {

    public Options getCliOptions();
    public List<Option> getSupportedOptions();
}
