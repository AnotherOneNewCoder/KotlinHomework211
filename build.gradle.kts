import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlin.jvm.internal.Intrinsics.Kotlin

plugins {
    id ("java")
    id ("org.jetbrains.kotlin.jvm") version ("1.5.20")
    id ("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //testImplementation(kotlin("test"))
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation ("junit:junit:4.13.2")
}
//
tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


//compileKotlin {
//    kotlinOptions.jvmTarget = "1.8"
//}
//compileTestKotlin {
//    kotlinOptions.jvmTarget = "1.8"
//}

