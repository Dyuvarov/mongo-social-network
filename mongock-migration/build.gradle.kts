plugins {
    kotlin("jvm") apply true
    kotlin("plugin.allopen") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("maven-publish")
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.dyuvarov"
version = "0.0.1"

val mongockVersion = "5.5.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("io.mongock:mongock-bom:5.5.1")
    }
}

dependencies {
    //db
    api("org.springframework.boot:spring-boot-starter-data-mongodb:3.4.1")
    api("io.mongock:mongock-springboot-v3:$mongockVersion")
    api("io.mongock:mongodb-springdata-v4-driver:$mongockVersion")

    api("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

tasks.register<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}

tasks.register<Wrapper>("wrapper") {
    gradleVersion = "7.5.1"
}

publishing {
    publications {
        create<MavenPublication>("maveJavan") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
        }
    }
    repositories {
        mavenLocal()
    }
}
