plugins {
    id("application")
    id("java")
    id("idea")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.emeraldcraft.engine:api:0.3")
    runtimeOnly("org.emeraldcraft.engine:engine:0.3")

    compileOnly("org.jetbrains:annotations:24.0.1")
}
application {
    mainClass.set("org.emeraldcraft.examples.Main")
}
idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}

group = "org.emeraldcraft.examples"
version = "0.1"