plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
    kotlin("plugin.serialization").version(libs.versions.kotlin.get())
    id("io.ktor.plugin") version libs.versions.ktor.get()
}

group = "com.ougi.authentication"
version = "0.0.1"

application {
    mainClass.set("com.ougi.authentication.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.jwt)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.contentNegotiation)
}
