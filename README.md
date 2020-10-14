# BaseRetrofitkt

Please Enable [Retrofit](https://square.github.io/retrofit/) on your project, follow this step.
 
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
