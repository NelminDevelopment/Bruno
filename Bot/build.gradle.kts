plugins {
    kotlin("jvm") version "2.1.10"
}

group = "dev.nelmin.discord"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("net.dv8tion:JDA:5.3.0")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}