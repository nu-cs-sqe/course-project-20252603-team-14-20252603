plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.14"
}

group = "nu.csse.sqe"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

javafx {
    version = "17.0.10"
    modules("javafx.controls", "javafx.fxml")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

application {
    mainClass.set("ui.ExplodingKittensApp")
}

tasks.compileJava {
    options.release = 11
}

tasks.test {
    useJUnitPlatform()
}