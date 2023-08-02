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
    implementation("org.emeraldcraft.engine:api:0.1")
    runtimeOnly("org.emeraldcraft.engine:engine:0.1")
}
application {
    mainClass.set("org.emeraldcraft.examples.main")
}
idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}

group = "org.emeraldcraft.examples"
version = "0.1"