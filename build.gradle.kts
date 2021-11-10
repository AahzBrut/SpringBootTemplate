import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.0-RC"
    kotlin("plugin.spring") version "1.6.0-RC"
    kotlin("plugin.jpa") version "1.6.0-RC"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.liquibase:liquibase-core:4.4.3")
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.5.6")
    runtimeOnly("com.h2database:h2:1.4.200")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.5.6")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "16"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val userHome: String = System.getProperty("user.home")

tasks.withType<Delete>{
    delete ("$userHome/kotlin-template/db")
}
