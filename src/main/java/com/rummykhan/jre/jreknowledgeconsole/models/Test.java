package com.rummykhan.jre.jreknowledgeconsole.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Test {

    @Id
    private String id;
    private Boolean test;
}
