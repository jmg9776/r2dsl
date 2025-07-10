package io.github.jmg9776.r2dsl.internal

class Query {
    private val select = Select()
    private var fromTable: String? = null
    private var where: Where? = null

    fun select(block: Select.() -> Unit) {
        select.block()
    }

    fun from(table: String) {
        fromTable = table
    }

    fun where(block: Where.() -> Unit) {
        where = Where().apply(block)
    }

    fun build(): String {
        require(select.columns.isNotEmpty()) { "SELECT 절이 비어있습니다" }
        require(!fromTable.isNullOrBlank()) { "FROM 절이 없습니다" }

        return buildString {
            append("SELECT ${select.columns.joinToString(", ")} FROM $fromTable")
            where?.let {
                append(" WHERE ${it.conditions.joinToString(" AND ")}")
            }
        }
    }
}
