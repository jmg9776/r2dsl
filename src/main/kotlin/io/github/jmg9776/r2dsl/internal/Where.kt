package io.github.jmg9776.r2dsl.internal

@R2DslMarker
class Where {
    val conditions = mutableListOf<String>()
    operator fun String.unaryPlus() {
        conditions += this
    }
}
