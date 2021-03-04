package com.rummykhan.jre.jreknowledgeconsole.router;

import com.rummykhan.jre.jreknowledgeconsole.cli.OptionManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RouterImpl implements Router{

    @Autowired
    private OptionManager optionManager;

    @Override
    public void route(CommandLine commandLine) {

    }
}
