plugins {
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.serialization") version "1.8.22"
    application
}

group = "ua.mani123"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    api("com.electronwill.night-config:json:3.6.6")
    api("ch.qos.logback:logback-classic:1.4.7")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.5.1")


    compileOnly("org.projectlombok:lombok:1.18.28")

    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")

    testImplementation(kotlin("test"))
}

tasks {
    withType<JavaCompile>().configureEach {
        options.encoding = Charsets.UTF_8.name()
    }
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("Main")
}