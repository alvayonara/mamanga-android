object ApplicationId {
    val id = "com.alvayonara.mamanga"
}

object Modules {
    val app = ":app"
    val common = ":common"
    val commonTest = ":common_test"
    val core = ":core"
    val feature = ":feature"
    val navigation = ":navigation"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0.0"
}

object Versions {
    val kotlin = "1.5.31"
    val gradle = "7.1.2"
    val compileSdk = 31
    val minSdk = 24
    val targetSdk = 31
    val appCompat = "1.4.1"
    val coreKtx = "1.7.0"
    val constraintLayout = "2.1.3"
    val junit = "4.13.2"
    val androidTestRunner = "1.1.2-alpha02" // need check
    val espressoCore = "3.2.0-alpha02" // need check
    val retrofit = "2.9.0"
    val retrofitGson = "2.9.0"
    val gson = "2.9.0"
    val okHttp = "3.12.1" // need check
    val coroutines = "1.6.0"
    val dagger = "2.40.5"
    val timber = "5.0.1"
    val lifecycle = "2.4.1"
    val lifecycleExtension = "2.2.0"
    val nav = "2.4.1"
    val room = "2.4.2"
    val recyclerview = "1.0.0" // need check
    val safeArgs = "2.4.2"
    val glide = "4.13.0"
    val archCoreTest = "2.0.0" // need check
    val androidJunit = "1.1.0" // need check
    val mockk = "1.12.0"
    val fragmentTest = "1.1.0-alpha06" // need check
    val material = "1.5.0"
    val swipeRefreshLayout = "1.1.0"
    val rxJava = "2.2.19"
    val rxAndroid = "2.0.0"
    val shimmer = "0.5.0"
    val epoxy = "4.6.3"
    val chucker = "3.5.2"
    val gravitySnapHelper = "2.2.2"
    val leakCanary = "2.9.1"
    val scrollingPageIndicator = "1.0.6"
    val activityKtx = "1.4.0"
    val fragmentKtx = "1.4.1"
    val legacy = "1.0.0"
    val compressor = "3.0.1"
}

object Libraries {
    // DAGGER 2
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    // RXJAVA 2
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    // ROOM
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val rxJavaRoom = "androidx.room:room-rxjava2:${Versions.room}"
    // RETROFIT
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    val rxJavaRetrofit = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    // GLIDE
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    // TIMBER
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    // SHIMMER
    val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    // EPOXY
    val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    val epoxyProcessor = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
    // CHUCKER
    val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
    // LEAK CANARY
    val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    // GRAVITY SNAP HELPER
    val gravitySnapHelper = "com.github.rubensousa:gravitysnaphelper:${Versions.gravitySnapHelper}"
    // SCROLLING PAGE INDICATOR
    val scrollingPageIndicator = "ru.tinkoff.scrollingpagerindicator:scrollingpagerindicator:${Versions.scrollingPageIndicator}"
    // COMPRESSOR
    val compressor = "id.zelory:compressor:${Versions.compressor}"
}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtension}"
    val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    val material = "com.google.android.material:material:${Versions.material}"
    val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
}

object TestLibraries {
    // ANDROID TEST
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"
    // MOCK WEBSERVER
    val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
    // MOCK
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    // COROUTINE
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}