import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.7.20"
}

group = "org.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    metadata {
    }
    jvm {
        withJava()
    }
    js() {
        browser {
        }
    }

    sourceSets {
        val commonMain by getting {
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}