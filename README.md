# Fuze app

An android app that will display a list of CS: GO matches in a given period of time. For that, the [PandaScore](https://pandascore.co/) API will be used.
# Screenshots

- SplashScreen

For the splash screen the [SplashScreen API](https://developer.android.com/develop/ui/views/launch/splash-screen) was used.

<img src="https://user-images.githubusercontent.com/41413741/226225355-b8ce72fa-2a38-4eac-835a-601f055c75f5.png" width="250" />

- Main Screen (Matches List)

In the main screen will display a list of matches, beginning from the current date. The list should be sorted so that currently playing matches will appear on top. For pagination, [Paging](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) was used. If something goes wrong to download more content (ex: internet lost connection after paging initialization), will show retry button to reload the matches list.
Some teams doens't have image photo, in this case a grey circle will appear.

<img src="https://user-images.githubusercontent.com/41413741/226223980-eb0e6904-4f3b-4406-b60a-17bc96540b58.png" width="250" /> <img src="https://user-images.githubusercontent.com/41413741/226223070-772b1138-1908-4499-836f-745e59ab0287.png" width="250" /> <img src="https://user-images.githubusercontent.com/41413741/226223076-4d2b9d67-3bd2-49e5-903f-8e8f79d3ef08.png" width="250" />

If the user clicks on a match that does not have all teams defined, a Toast message will appear

<img src="https://user-images.githubusercontent.com/41413741/226226302-225e2d36-91da-47ff-ac53-a78c6cf22551.png" width="250" />

- Match Detail Screen
 
 This screen will appear when the user selects a match from the main screen. Some players doens't have image photo, in this case a grey square will appear.
 
 <img src="https://user-images.githubusercontent.com/41413741/226224977-057f2fbe-c53e-48b2-b854-1f78f0a6533b.png" width="250" />

 
---
# Tech Stack

- [Jetpack Libraries](https://developer.android.com/jetpack/androidx/explorer?gclid=Cj0KCQjw0PWRBhDKARIsAPKHFGg1spKQZuAwQdZ1kzALkPlrRRJjWErjAqqvtRWRyduAAoosC_mTZzUaApnyEALw_wcB&gclsrc=aw.ds&case=all&hl=pt-br)
    - [Hilt](https://dagger.dev/hilt/) - Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    - [MVVM](https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=CjwKCAjw-rOaBhA9EiwAUkLV4uTWtmhSLWBc9oaYTl_gJJsgJiF-w2indn-p5PnLtnXKs-9elvGQlxoC1jkQAvD_BwE&gclsrc=aw.ds) - ViewModel is a class that is responsible for preparing and managing the data for an Activity or a Fragment . It also handles the communication of the Activity / Fragment with the rest of the application (e.g. calling the business logic classes).
- [CoilImage Loader](https://github.com/coil-kt/coil) - An image loading library for Android backed by Kotlin Coroutines. 
- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client 
and supports coroutines out of the box.
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse 
requests on the data layer for Entities and understands Kotlin non-nullable 
and default parameters.
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - LiveData follows the observer pattern. LiveData notifies Observer objects when underlying data changes.
