plugins {
    java
    id("fabric-loom") version "1.3.6"
}

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.21")
    mappings("net.fabricmc:yarn:1.21+build.1:v2")
    modImplementation("net.fabricmc:fabric-loader:0.15.2")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.89.0+1.21")
}
