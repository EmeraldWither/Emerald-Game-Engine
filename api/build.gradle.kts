plugins {
    id("java-library")
    id("maven-publish")
    id("idea")
    id("eclipse")
}

group = "org.emeraldcraft"
version = "v0.2"

repositories {
    mavenCentral()
    mavenLocal()
}
idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}
eclipse {
    classpath {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}

dependencies {
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
            artifactId = "api"
            version = project.version.toString().replace("v", "")
            from(components["java"])
        }
    }
}
tasks.jar {
    from(sourceSets["main"].allSource)
}