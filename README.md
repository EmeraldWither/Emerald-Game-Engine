# Emerald Game Engine

### This is still a work in progress! Many features are not finished

This is an upgraded version of my game engine which I used to make my end-of-year AP Computer Science A Project.

This project is mainly a personal project, and is designed to be used by students who have just finished APCSA.

## Features
* (In Progress) Physics Engine provided by dyn4j
* Easy creation of basic games
* Automatic rendering
* Multi-threaded

## Building using Gradle

This project uses Gradle to handle the building of the code. This project is not on any maven repo, so manually adding it to your local repository will be needed

After cloning this repo, run `gradlew publishToMavenLocal`.

Then, include the following in your projects `build.gradle.kts`
```kotlin
plugins {  
	id("application")  
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
	mainClass.set(MAIN CLASS)  
}
```


Checkout the `example-game` module for an example game which implements physics.