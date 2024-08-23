plugins {
    id("kotlin-kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.app.mybaseapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.mybaseapp"
        minSdk = 24
        targetSdk = 34
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
            buildConfigField("String", "BASE_URL", "\"https://reqres.in/api/\"")
        }

        debug {
            isDebuggable = true
            buildConfigField("String", "BASE_URL", "\"https://reqres.in/api/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    //for enable view binding
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //navigation component
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)

    //fragment ktx
    implementation(libs.fragment.ktx)

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Retrofit
    implementation(libs.retrofit.retrofit2)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.retrofit.logging)

    //Glide
    implementation(libs.glide)

    //Circular Image view
    implementation(libs.circular.imageview)


}