// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
}

plugins {
    id(Plugins.APPLICATION) version Versions.GRADLE apply false
    id(Plugins.LIBRARY) version Versions.GRADLE apply false
    id(Plugins.KOTLIN) version Versions.KOTLIN apply false
}

// Caused errors on JitPack
//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}