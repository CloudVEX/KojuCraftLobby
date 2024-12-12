plugins {
    kotlin("jvm") version "2.+"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
    id("io.papermc.paperweight.userdev") version "1.7.+"
    id("xyz.jpenilla.run-paper") version "2.3.0"
}

group = "de.cloudvex"
version = "1.0"

val serverVersion: String by project
val packageString = "${properties["group"] as String}.${rootProject.name.lowercase()}"

val commandApiVersion: String by project
val twilightVersion: String by project
val gsonVersion: String by project

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://repo.flyte.gg/releases")
}

dependencies {
    paperweight.paperDevBundle("$serverVersion-R0.1-SNAPSHOT")

    implementation(kotlin("stdlib"))

    library("dev.jorel:commandapi-bukkit-shade-mojang-mapped:$commandApiVersion")
    library("dev.jorel:commandapi-bukkit-kotlin:$commandApiVersion")
    library("gg.flyte:twilight:$twilightVersion")
    library("com.google.code.gson:gson:$gsonVersion")
}

paper {
    name = properties["name"] as String
    version = project.version.toString()
    author = properties["author"] as String
    description = properties["description"] as String
    website = properties["website"] as String

    main = "$packageString.Main"

    loader = "$packageString.CustomLoader"
    generateLibrariesJson = true
    apiVersion = "1.21"
}

kotlin {
    jvmToolchain(21)
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(21)
    }
    runServer {
        minecraftVersion(serverVersion)
    }
}