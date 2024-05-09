plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
//    id ("com.kezong.fat-aar")
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
            withSourcesJar()
            withJavadocJar()
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
            version = "1.0.7"

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
    implementation(files("libs/logging-interceptor-5.0.0-alpha.14.jar"))
    implementation (project(":fingpaymicroatm-release"))
//    api(fileTree(mapOf("include" to listOf("fingpaymicroatm-release.aar"), "dir" to "libs")))
//    implementation(project(":finpay"))
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
//    implementation (libs.logging.interceptor)
    implementation(libs.okhttp)
    implementation (libs.okio)
    implementation (libs.gson)
    implementation(libs.converter.scalars)
    implementation(libs.bcprov.jdk15on)

}