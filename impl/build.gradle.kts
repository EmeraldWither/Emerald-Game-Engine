plugins {
    id("java-library")
    id("maven-publish")

}

group = "org.emeraldcraft"
version = "0.2"

repositories {
    mavenCentral()
    mavenLocal()
}

java {
    withSourcesJar()
}

dependencies {
    implementation(project(":api"))

    compileOnly("org.jetbrains:annotations:24.0.1")

    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.emeraldcraft.engine"
            artifactId = "engine"
            version = project.version.toString().replace("v", "")

            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/EmeraldWither/Emerald-Game-Engine")

            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}
tasks.jar {
    from(sourceSets["main"].allSource)
}