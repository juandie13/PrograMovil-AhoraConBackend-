package pe.edu.ulima.activities.configs

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BackendClient {
    const val BASE_URL = "https://tercerentregable.juandie13.repl.co/"
    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}