package io.github.jmg9776.r2dsl

import io.github.jmg9776.r2dsl.internal.query
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class R2DslTest {

    @Test
    fun `simple query should generate correct SQL`() {
        val sql = query {
            select {
                +"id"
                +"name"
            }
            from("users")
            where {
                +"age > 18"
                +"status = 'ACTIVE'"
            }
        }

        val expected = "SELECT id, name FROM users WHERE age > 18 AND status = 'ACTIVE'"
        assertEquals(expected, sql)
    }
}
