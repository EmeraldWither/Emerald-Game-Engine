plugins {
    id("java-library")
}

group = "org.emeraldcraft"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))

    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")
}
