package app

import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {
    @GET("game/{id}")
    suspend fun getGameById(@Path("id") id: Int): Game
}
