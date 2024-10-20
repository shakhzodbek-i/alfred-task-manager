// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.7.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "8.7.1" apply false
    kotlin("kapt") version "2.0.21"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
}