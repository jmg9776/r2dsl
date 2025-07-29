# R2dsl

**R2dsl** is a lightweight, type-safe DSL and ORM-style query builder designed for the reactive stack using **Kotlin + R2DBC + Spring WebFlux**.

It allows you to define SQL queries declaratively using Kotlin DSL, while automatically mapping query results to DAO classes. It improves readability, productivity, and debugging experience without compromising the reactive nature of your application.

---

## 🚀 Why R2dsl?

While WebFlux and R2DBC are becoming common in reactive applications, existing tools like JPA or QueryDSL either don't work or are not designed for non-blocking environments.

Key limitations with current options:

- **JPA is blocking** and cannot be used with WebFlux.
- **Spring Data R2DBC lacks a proper DSL** and offers only basic CRUD functionality.
- **Manual mapping required**: Query results need to be handled manually with `Row.get(...)`, making the code verbose and error-prone.

R2dsl solves these problems by providing a reactive-first, expressive DSL with automatic object mapping.

---

## ✨ Features

- **Kotlin-based DSL** for building SQL queries in a declarative and safe way
- **Reactive support** using R2DBC and Spring WebFlux
- **Automatic mapping to DAO/Entity classes** via reflection
- **Query caching**: DSL is compiled only once unless the structure changes
- **Debug logging**: SQL template and bound parameters are logged in debug mode

---

## 🧑‍💻 Example Usage

```kotlin
val query = query {
    select { +"id"; +"name" }
    from("users")
    where {
        "age" gt 18
        "status" eq "ACTIVE"
    }
}

val users: List<User> = query.fetchAs<User>()
````

### With object-based filtering

```kotlin
val condition = UserSearch(age = 25, status = "ACTIVE")

query {
    from("users")
    where(condition)
}
```

### Debug output (when debug mode is enabled)

```
[R2dsl] SQL → SELECT id, name FROM users WHERE age > ? AND status = ?
[R2dsl] Bindings → [18, ACTIVE]
```

---

## 🧱 Core Architecture

| Component    | Description                                             |
| ------------ | ------------------------------------------------------- |
| DSL Builder  | Builds internal AST using Kotlin DSL                    |
| AST to SQL   | Converts AST into parameterized SQL templates           |
| DAO Mapper   | Maps `Row` to Kotlin data classes via reflection        |
| Query Cache  | DSL hash-based cache prevents unnecessary recompilation |
| Debug Logger | Logs SQL + parameters only in development mode          |

---

## 🔍 Debug & Tracing

In development mode, the query engine logs the generated SQL and parameter values to aid debugging. This behavior is disabled in production environments.

```kotlin
val engine = QueryEngine(debug = true)
engine.execute(queryDsl) // SQL and bindings will be printed
```

---

## 📈 Roadmap (Phase 1)

| Phase | Feature                                          |
| ----- | ------------------------------------------------ |
| 1     | DSL Builder + AST construction                   |
| 2     | SQL generation and parameter extraction          |
| 3     | R2DBC execution engine                           |
| 4     | Reflection-based DAO mapping                     |
| 5     | Debug logging                                    |
| 6     | Pagination, sorting, subqueries, joins (planned) |

---

## 🛠 Tech Stack

* Kotlin
* Spring WebFlux
* R2DBC (H2, PostgreSQL, etc.)
* Kotlin Reflection
* SLF4J / Kotlin Logging
* Kotest or JUnit 5

---

## 📝 License

Apach 2.0

---

## 📌 Status

🚧 Planned, not implemented yet.
