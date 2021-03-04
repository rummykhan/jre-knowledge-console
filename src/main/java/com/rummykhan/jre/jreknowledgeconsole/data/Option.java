package com.rummykhan.jre.jreknowledgeconsole.data;

import lombok.Data;

@Data
public class Option {
    private String description;
    private String command;
    private boolean hasArguments;

    public Option(String command, String description, boolean hasArguments) {
        this.command = command;
        this.description = description;
        this.hasArguments = hasArguments;
    }
}
