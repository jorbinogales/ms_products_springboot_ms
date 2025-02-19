val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.20"
    id("io.ktor.plugin") version "2.2.3"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.20"
}

group = "ktor"
version = "0.0.1"

application {
    mainClass.set("ktor.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("org.jetbrains.exposed", "exposed-core", "0.38.1")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.38.1")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.38.1")
    implementation("org.postgresql:postgresql:42.7.2")
}
