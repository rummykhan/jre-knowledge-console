package com.rummykhan.jre.jreknowledgeconsole.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "test")
public class Test {

    @Id
    private String id;

    private Boolean test;

    private String name;

    @CreatedDate
    public LocalDateTime created_at;

    @LastModifiedDate
    public LocalDateTime updated_at;

    public Test(String name, Boolean test){
        this.name = name;
        this.test = test;
    }
}
