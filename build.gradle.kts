plugins{
    id("java-library")
    id("idea")
    id("eclipse")
    id("maven-publish")
    //id("com.github.johnrengelman.shadow") version "8.1.1"
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

repositories {
    mavenCentral()
    mavenLocal()
}
val mergedJar by configurations.creating<Configuration> {
    // we're going to resolve this config here, in this project
    isCanBeResolved = true
    // this configuration will not be consumed by other projects
    isCanBeConsumed = false
    // don't make this visible to other projects
    isVisible = false
}


dependencies {
    mergedJar(project(":api"))
    mergedJar(project(":impl"))

    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")
}
