plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "ua.mani123"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.shadowJar {
    archiveFileName.set("" + findProperty("project-name") + "-v" + version + ".jar")
}

tasks.test {
    useJUnitPlatform()
}