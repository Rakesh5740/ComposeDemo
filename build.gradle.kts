buildscript {
    dependencies {
//        classpath (libs.kotlin.gradle.plugin)
        classpath (libs.hilt.android.gradle.plugin.v2381)
    }
}

plugins {
    id("com.android.library") version "8.1.4" apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.android.application") version "8.7.3" apply false
    id("com.google.devtools.ksp") version ("2.0.0-1.0.22") apply false
}

//repositories {
//    google()
//    mavenCentral()
//    maven { url = uri("https://jitpack.io") }
//}