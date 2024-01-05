plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.intermodular.hotel"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.intermodular.hotel"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("io.coil-kt:coil-compose:2.0.0")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")  //Distribuición
    implementation("androidx.navigation:navigation-compose:2.7.5")              //Navigator
    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")           //Server
    implementation("com.squareup.retrofit2:retrofit:2.9.0")                     //Conexiones API Rest libreria Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")               //Conexions API Rest
    implementation("com.google.dagger:hilt-android:2.48.1")                     //Inyección dependencias
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")                      //Inyección dependencias
    implementation("io.coil-kt:coil:2.5.0")                                     //Url a imagen
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")                      //":1.1.2"
    implementation("androidx.compose.material:material-icons-extended:1.5.4")
}

kapt {
    correctErrorTypes = true
}