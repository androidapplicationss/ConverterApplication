// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    val room_version = "2.6.1"
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("androidx.room") version "$room_version" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Use the latest version of Gradle plugin compatible with Java 17 and Gradle version
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath("androidx.room:room-gradle-plugin:2.6.1")
        // Other classpath dependencies if necessary
    }
}
