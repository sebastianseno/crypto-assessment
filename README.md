# Crypto currency mini apps modularization

In this mini app I also adding login validation to prevent user input incorrect email format and incorrect password and also that case I used for unit testing scenario.
To login in this app please fill with valid email format (eg: email@bibi.com) and fill password with 4 or more characters digit.
### In this application I use these libraries :

#### Dependency Injection
Hilt as dependency Injection
Library :
```
    implementation 'com.google.dagger:hilt-android:2.35'
    kapt "com.google.dagger:hilt-android-compiler:2.35"
    // hilt viewModel extension
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:$hilt_version"
    kapt "androidx.hilt:hilt-compiler:$hilt_version"
```

####  Navigation Component
Jetpack as Navigation component
Library :
```
    implementation "androidx.navigation:navigation-fragment-ktx:$navigation_version"
    implementation "androidx.navigation:navigation-ui-ktx:$navigation_version"
```
####  Networking
For Fetching Api I use network
Library :
```
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:okhttp:$okhttp_version"
    implementation "com.squareup.okhttp3:logging-interceptor:$okhttp_version"
    implementation 'com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2'
```

#### Asynchronous
For reactive programming I use coroutine
Library :
```
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$corutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$corutines_version"
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
```

####  Unit Testing
Hilt unit testing
Library :
```
    androidTestImplementation "com.google.dagger:hilt-android-testing:$hilt_version"
    kaptAndroidTest "com.google.dagger:hilt-android-compiler:$hilt_version"
```
