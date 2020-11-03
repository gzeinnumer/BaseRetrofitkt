# BaseRetrofitkt

Please Enable [Retrofit](https://square.github.io/retrofit/) on your project, follow this step.

```gradle
implementation 'com.squareup.retrofit2:retrofit:2.6.0'
implementation 'com.google.code.gson:gson:2.8.5'
implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
implementation 'com.squareup.okhttp3:okhttp:3.12.0'
```

- Make Class RetroServer
```kotlin
object RetroServer {

    private const val base_url = "https://www.themealdb.com/api/json/v1/1/"

    private fun setInit(): Retrofit {
        Log.d("MyZeinSistem", "RetroServer + setInit")

        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val instance: ApiService
        get() = setInit().create<ApiService>(ApiService::class.java)
}
```
