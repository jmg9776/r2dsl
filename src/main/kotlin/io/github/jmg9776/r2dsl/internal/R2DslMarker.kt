package io.github.jmg9776.r2dsl.internal

@DslMarker
annotation class R2DslMarker

@R2DslMarker
class Select {
    val columns = mutableListOf<String>()
    operator fun String.unaryPlus() {
        columns += this
    }
}
