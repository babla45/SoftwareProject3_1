plugins {
    id 'com.android.application' // Apply the Android application plugin
    id 'com.google.gms.google-services' // Apply the Google services plugin
}

android {
    namespace = "com.example.softwareproject3_1"
    compileSdkVersion 34 // Use compileSdkVersion instead of compileSdk

    defaultConfig {
        applicationId "com.example.softwareproject3_1"
        minSdkVersion 24 // Use minSdkVersion instead of minSdk
        targetSdkVersion 34 // Use targetSdkVersion instead of targetSdk
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false // Use minifyEnabled instead of isMinifyEnabled
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:latest_version'
    implementation 'com.google.android.material:material:latest_version'
    implementation 'androidx.activity:activity:latest_version'
    implementation 'androidx.constraintlayout:constraintlayout:latest_version'
    implementation 'androidx.recyclerview:recyclerview:latest_version' // Resolved RecyclerView conflict
    implementation 'com.google.firebase:firebase-firestore:latest_version' // Resolved Firestore dependency
    implementation 'com.google.firebase:firebase-auth:latest_version' // Resolved Firebase Auth dependency
    implementation 'com.google.firebase:firebase-database:latest_version' // Resolved Firebase Database dependency

    testImplementation 'junit:junit:latest_version'
    androidTestImplementation 'androidx.test.ext:junit:latest_version'
    androidTestImplementation 'androidx.test.espresso:espresso-core:latest_version'
    testImplementation "org.mockito:mockito-core:3.12.4" // Added Mockito dependency
    testImplementation "org.robolectric:robolectric:4.6.1" // Added Robolectric dependency
}

