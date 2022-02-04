plugins {
    id(Plugins.LIBRARY)
    id(Plugins.KOTLIN_ANDROID)

    id(Plugins.MAVEN)
}

android {
    compileSdk = App.COMPILE_SDK
    buildToolsVersion = App.BUILD_TOOLS

    defaultConfig {
        minSdk = App.MIN_SDK
        targetSdk = App.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
    buildFeatures {
        buildConfig = false
    }
}

dependencies {

    coreLibraryDesugaring(Libs.DESUGARING)

    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.PLAY_SERVICES)

}
project.afterEvaluate {
    this.publishing.publications {
        create<MavenPublication>("release") {
            groupId = "cz.lastaapps.common"
            artifactId = "common"
            version = App.artifactVersion

            from(components["release"])

            pom {
                name.set("Lasta Apps Play Services")
                description.set("Helper classes for working with Play Services")
                url.set("http://github.com/Lastaapps/Lasta_Apps_Common")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://github.com/Lastaapps/Lasta_Apps_Common/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("Lasta Apps")
                        name.set("Petr Laštovička")
                        email.set("lastaappsdev@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Lastaapps/Lasta_Apps_Common.git")
                    developerConnection.set("scm:git:ssh://github.com/Lastaapps/Lasta_Apps_Common.git")
                    url.set("http://github.com/Lastaapps/Lasta_Apps_Common/")
                }
            }
        }
    }
}
