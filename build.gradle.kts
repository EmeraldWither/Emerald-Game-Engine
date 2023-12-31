plugins{
    id("java-library")
    id("idea")
    id("eclipse")
    id("maven-publish")
    //id("com.github.johnrengelman.shadow") version "8.1.1"
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
