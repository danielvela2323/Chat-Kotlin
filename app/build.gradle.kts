plugins {
    alias(libs.plugins.android.application)
    // Add the Google services Gradle plugin
    //id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.chat_kotlin"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.chat_kotlin"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    //Necesario para la creacion de NavigationBottomView
    buildFeatures{
        viewBinding = true;
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    // Import the Firebase BoM
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation(platform("com.google.firebase:firebase-bom:34.17.0"))

    // Add the dependency for Firebase Analythics
    implementation("com.google.firebase:firebase-analytics")

    // Add the dependency for the Firebase Authentication library
    implementation("com.google.firebase:firebase-auth")

    // Add the dependency for the Realtime Database library
    implementation("com.google.firebase:firebase-database")
    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries
}



