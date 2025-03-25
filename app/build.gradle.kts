plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.cse225_codes"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cse225_codes"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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
    // Add the CircleImageView dependency
    implementation(libs.circleimageview)
    // Add StyleableToast dependency
    implementation("io.github.muddz:styleabletoast:2.4.0")
    implementation("com.github.5AbhishekSaxena.toaster-android:toaster:2.3.1")
    implementation("com.github.5AbhishekSaxena.toaster-android:toaster-ktx:2.3.1")
    implementation("com.github.GrenderG:Toasty:1.5.2")

    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation(libs.lottie)
    implementation("com.github.rubygarage:emotion-rating-view:v1.0.1")
    implementation ("com.github.sujithkanna:smileyrating:2.0.0")
}