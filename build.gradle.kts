plugins{
    id("java-library")
    `maven-publish`
    //id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
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


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.emeraldcraft.engine"
            artifactId = "engine"
            version = "0.1"

            from(components["java"])
        }
    }
}

tasks.jar {
    dependsOn(mergedJar)

    from({
        mergedJar
                .filter {
                    it.name.endsWith("jar") && it.path.contains(rootDir.path)
                }
                .map {
                    logger.lifecycle("depending on $it")
                    zipTree(it)
                }
    })
}
