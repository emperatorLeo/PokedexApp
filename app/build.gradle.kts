plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id(libs.plugins.hilt.kapt.get().pluginId)
    id(libs.plugins.hilt.plugin.get().pluginId)
    id(libs.plugins.ksp.plugin.get().pluginId)
}

android {
    namespace = "com.example.pokedexapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pokedexapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.gson.converter)

    // Okhttp
    implementation(libs.okhttp)

    // Gson
    implementation(libs.gson)

    // Hilt
    implementation(libs.hilt)
    implementation(libs.hilt.navigation)
    kapt(libs.hilt.kapt)

    // Arrow
    implementation(libs.arrow)

    // Room
    implementation(libs.room)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    annotationProcessor(libs.room.compiler)

    // Coil
    implementation(libs.coil)
    implementation(libs.coil.network)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

kapt {
    correctErrorTypes = true
}