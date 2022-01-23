plugins {
    id("com.android.library")
    id("kotlin-android")

    id("maven-publish")
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

        buildConfigField("java.lang.String", "BUILD_DATE", "\"${App.buildDate}\"")
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
        buildConfig = true
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
            version = "1.3.0"

            from(components["release"])

            pom {
                name.set("Lasta Apps Common")
                description.set("Helper classes and resources")
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
