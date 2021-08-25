plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = App.COMPILE_SDK
    buildToolsVersion = App.BUILD_TOOLS

    defaultConfig {
        applicationId = App.APP_ID
        minSdk = App.MIN_SDK
        targetSdk = App.TARGET_SDK
        versionCode = App.VERSION_CODE
        versionName = App.VERSION_NAME

        resourceConfigurations += setOf("en")

        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
}

dependencies {

    implementation(project(":lib"))

    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)

}