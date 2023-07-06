plugins {
    id("java-library")
    `maven-publish`
}

group = "org.emeraldcraft"
version = "v0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.dyn4j:dyn4j:4.2.0")

    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.emeraldcraft.engine"
            artifactId = "api"
            version = "0.1"

            from(components["java"])
        }
    }
}
