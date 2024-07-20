<div align="center">
    <h1>Movie App</h1>
</div>

## Overview

- Built entirely in [Kotlin](https://kotlinlang.org/) with [Coroutines](https://developer.android.com/kotlin/coroutines) for efficient asynchronous programming.
  
- ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.

- [DataBinding](https://developer.android.com/topic/libraries/data-binding): Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.

- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): for dependency injection.

- [Retrofit2](https://square.github.io/retrofit/) & [OkHttp3](https://square.github.io/okhttp/): Construct the REST APIs.

- [Glide](https://bumptech.github.io/glide/) for efficient image loading and caching.

- Pagination: Implements pagination to efficiently load and display large datasets from the Movie API, enhancing user experience with seamless scrolling and data loading.

- [ksp](https://developer.android.com/build/migrate-to-ksp): Kotlin Symbol Processing API.

- [Timber](https://github.com/JakeWharton/timber): A logger with a small, extensible API.

- [Secrets Gradle](https://developers.google.com/maps/documentation/places/android-sdk/secrets-gradle-plugin): Read the API key.

- [Lottie](https://lottiefiles.com/): for animations.

- [Test](https://developer.android.com/training/testing/local-tests) : for ViewModel tests.

- Multi-Language: Turkish and English.

- Light/Dark Mode

## Architecture

The Movie App follows the MVVM architecture pattern along with the Repository pattern, adhering to [Google's recommended architecture](https://developer.android.com/topic/architecture).