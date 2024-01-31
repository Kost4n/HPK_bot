import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"

    kotlin("jvm") version "1.7.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    /** TELEGRAM API */
    implementation("org.telegram:telegrambots-spring-boot-starter:6.8.0")
    implementation("org.telegram:telegrambotsextensions:6.8.0")

    /** SPRING WEB */
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")

//    implementation("org.jetbrains.kotlin:1.2.41")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs += "-Xjsr305=strict"
}