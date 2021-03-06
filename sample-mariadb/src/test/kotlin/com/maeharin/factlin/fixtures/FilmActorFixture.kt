package com.maeharin.factlin.fixtures

import java.time.LocalDateTime
import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class FilmActorFixture (
    val actor_id: Short = 0, // 
    val film_id: Short = 0, // 
    val last_update: LocalDateTime = LocalDateTime.now() // 
)

fun DbSetupBuilder.insertFilmActorFixture(f: FilmActorFixture) {
    insertInto("film_actor") {
        mappedValues(
                "actor_id" to f.actor_id,
                "film_id" to f.film_id,
                "last_update" to f.last_update
        )
    }
}