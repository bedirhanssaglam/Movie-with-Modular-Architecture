<div align="center">
    <h1>Movie App with Modular Architecture</h1>
</div>

## Overview

- Minimum SDK level 24

- Built entirely in [Kotlin](https://kotlinlang.org/) with [Coroutines](https://developer.android.com/kotlin/coroutines) for efficient asynchronous programming.
  
- ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.

- [DataBinding](https://developer.android.com/topic/libraries/data-binding): Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.

- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): for dependency injection.

- [Retrofit2](https://square.github.io/retrofit/) & [OkHttp3](https://square.github.io/okhttp/): Construct the REST APIs.

- [Glide](https://bumptech.github.io/glide/) for efficient image loading and caching.

- [ksp](https://developer.android.com/build/migrate-to-ksp): Kotlin Symbol Processing API.

- Pagination: Implements pagination to efficiently load and display large datasets from the Movie API, enhancing user experience with seamless scrolling and data loading.

- [Timber](https://github.com/JakeWharton/timber): A logger with a small, extensible API.

- [Secrets Gradle](https://developers.google.com/maps/documentation/places/android-sdk/secrets-gradle-plugin): Read the API key.

- [Lottie](https://lottiefiles.com/): for animations.

- [Test](https://developer.android.com/training/testing/local-tests) : for ViewModel tests.

- Multi-Language: Turkish and English.

- Light/Dark Mode

## Screenshots

<p float="left">
  <img src="https://github.com/user-attachments/assets/731cf15f-64d5-4753-8956-f57f5e5519af" width=150" />
  <img src="https://github.com/user-attachments/assets/6bcd1965-2d0b-4d3d-873b-137e8fee6672" width="150" />
  <img src="https://github.com/user-attachments/assets/329ce632-c2f7-4fec-a5f5-9b56715dd1ab" width=150" />
  <img src="https://github.com/user-attachments/assets/007bcace-d78f-452a-b047-c70a98b2d4d9" width="150" />
  <img src="https://github.com/user-attachments/assets/c7a7fe52-af2c-421c-b51a-2f67ea9fc679" width="150" />
</p>

## Architecture

The Movie App follows the MVVM architecture pattern along with the Repository pattern, adhering to [Google's recommended architecture](https://developer.android.com/topic/architecture).

And it is explained in detail in this article: [Modular Architecture in Android: An Analysis from a Movie App](https://medium.com/@bedirhanssaglam/modular-architecture-in-android-an-analysis-from-a-movie-app-ae55a26bda8f)

<div align="center">
    <img src="https://github.com/user-attachments/assets/edcedfc7-52b3-46d9-b236-4fa972e71148" alt="Architecture Diagram">
</div>

## API Integration

The app integrates with the [The Movie Database](https://www.themoviedb.org/) to fetch and display movie contents.
