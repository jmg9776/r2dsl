plugins {
    kotlin("jvm") version "2.1.20"
    id("com.vanniktech.maven.publish") version "0.34.0"
}

group = "io.github.jmg9776"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

mavenPublishing {
    coordinates(
        groupId = "io.github.jmg9776",
        artifactId = "r2dsl",
        version = "1.0.0"
    )

    pom {
        name.set("r2dsl-core")
        description.set("DSL and lightweight ORM for R2DBC written in Kotlin.")
        inceptionYear.set("2024")
        url.set("https://github.com/jmg9776/r2dsl")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("jmg9776")
                name.set("Min-Gyun Cho")
                email.set("jmg97@kakao.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/jmg9776/r2dsl.git")
            developerConnection.set("scm:git:ssh://github.com/jmg9776/r2dsl.git")
            url.set("https://github.com/jmg9776/r2dsl")
        }
    }

    publishToMavenCentral()
    signAllPublications()
}
