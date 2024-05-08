plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.acemoney.mylibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    publishing {
        singleVariant("release") {
//            withSourcesJar()
//            withJavadocJar()
        }
    }
    buildFeatures {
        viewBinding=true
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.aceware20"
            artifactId = "microatm"
            version = "1.0.5"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation(fileTree("libs") {
        include("*.jar")
    })
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //
    implementation(files("libs/ksoap2-android-assembly-3.6.4-jar-with-dependencies.jar"))
    implementation(files("libs/morefun_mpos_sdk_v2.1.20210628.jar"))
    implementation (project(":fingpaymicroatm-release"))
//    api(fileTree(mapOf("include" to listOf("fingpaymicroatm-release.aar"), "dir" to "libs")))
//    implementation(project(":finpay"))
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation ("com.squareup.okio:okio:3.8.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("org.bouncycastle:bcprov-jdk15on:1.68")

}