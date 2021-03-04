package com.rummykhan.jre.jreknowledgeconsole.repositories;

import com.rummykhan.jre.jreknowledgeconsole.models.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Test, String> {
}
