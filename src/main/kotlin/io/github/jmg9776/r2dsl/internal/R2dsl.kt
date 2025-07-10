package io.github.jmg9776.r2dsl.internal

fun query(block: Query.() -> Unit): String {
    val q = Query()
    q.block()
    return q.build()
}
