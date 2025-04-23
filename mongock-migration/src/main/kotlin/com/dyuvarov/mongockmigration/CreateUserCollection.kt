package com.dyuvarov.mongockmigration

import io.mongock.api.annotations.ChangeUnit
import io.mongock.api.annotations.Execution
import io.mongock.api.annotations.RollbackExecution
import org.springframework.data.mongodb.core.MongoTemplate

@ChangeUnit(id = "createUserCollection", order = "10")
class CreateUserCollection(
    private val mongoTemplate: MongoTemplate
) {
    @Execution
    fun createCollection() {
        mongoTemplate.createCollection("user")
    }

    @RollbackExecution
    fun rollback() {
        mongoTemplate.dropCollection("user")
    }
}
