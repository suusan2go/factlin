package com.maeharin.factlin.fixtures

import java.time.LocalDateTime
import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class LanguageFixture (
    val language_id: Byte = 0, // 
    val name: String = "", // 
    val last_update: LocalDateTime = LocalDateTime.now() // 
)

fun DbSetupBuilder.insertLanguageFixture(f: LanguageFixture) {
    insertInto("language") {
        mappedValues(
                "language_id" to f.language_id,
                "name" to f.name,
                "last_update" to f.last_update
        )
    }
}