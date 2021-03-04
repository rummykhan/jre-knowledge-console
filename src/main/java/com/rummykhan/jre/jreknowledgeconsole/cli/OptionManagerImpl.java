package com.rummykhan.jre.jreknowledgeconsole.cli;

import com.rummykhan.jre.jreknowledgeconsole.data.Option;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.Options;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class OptionManagerImpl implements OptionManager {

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options = addUserCliOptions(options);
        return options;
    }

    protected Options addUserCliOptions(Options options) {
        for (Option entry : this.getSupportedOptions()) {
            options.addOption(entry.getCommand(), entry.isHasArguments(), entry.getDescription());
            log.info("COMMAND {}, isRequired: {}, Description :{}", entry.getCommand(), entry.isHasArguments(), entry.getDescription());
        }
        return options;
    }

    public List<Option> getSupportedOptions() {
        List<Option> entries = new ArrayList<>();
        entries.add(new Option("h", "Help", false));
        entries.add(new Option("channel", "Select channel youtube / spotify", true));
        return entries;
    }
}
