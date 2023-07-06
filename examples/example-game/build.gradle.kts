plugins {
    id("application")
}

group = "org.emeraldcraft"
version = "unspecified"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.emeraldcraft.engine:api:0.1")
    runtimeOnly("org.emeraldcraft.engine:engine:0.1")
}
application {
    mainClass.set("org.emeraldcraft.examples.game.Main")
}