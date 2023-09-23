plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.apicallusingdagger2andrxjavaexample"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.apicallusingdagger2andrxjavaexample"
        minSdk = 28
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    // Retrofit and Gson for API calls
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.okhttp3:okhttp:4.3.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.3.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.4.0")

    // Dagger 2
    implementation ("com.google.dagger:dagger:2.37")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.37")

    // RxJava
    implementation ("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}