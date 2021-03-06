package com.maeharin.factlin.core

import com.maeharin.factlin.core.codegenerator.CodeGenerator
import com.maeharin.factlin.core.kclassbuilder.KClassBuilder
import com.maeharin.factlin.core.schemaretriever.SchemaRetriever
import com.maeharin.factlin.gradle.FactlinExtension
import org.slf4j.LoggerFactory

enum class Dialect {
    POSTGRES,
    MARIADB
}

data class FactlinCore(
        private val extension: FactlinExtension
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun exec() {
        val dialect = when(extension.dbDialect) {
            "postgres" -> Dialect.POSTGRES
            "mariadb" -> Dialect.MARIADB
            else -> throw Exception("dialect ${extension.dbDialect} is not supported")
        }

        val tables = SchemaRetriever(extension, dialect).retrieve()

        CodeGenerator(extension, tables, dialect).generate()
    }
}

