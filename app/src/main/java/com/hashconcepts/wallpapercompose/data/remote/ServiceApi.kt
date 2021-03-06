package com.hashconcepts.wallpapercompose.data.remote

import com.hashconcepts.wallpapercompose.common.Constants
import com.hashconcepts.wallpaperhd4k.data.models.WallpaperResponse
import okhttp3.ResponseBody
import retrofit2.http.*


interface ServiceApi {

    @Headers("Authorization: Bearer ${Constants.API_KEY}")
    @GET("curated?per_page=30")
    suspend fun getCuratedImages(
        @Query("page")
        page: Int = 1
    ): WallpaperResponse

    @Headers("Authorization: Bearer ${Constants.API_KEY}")
    @GET("search?per_page=30")
    suspend fun getImagesByCategory(
        @Query("page")
        page: Int = 1,
        @Query("query")
        query: String
    ): WallpaperResponse

    @Headers("Authorization: Bearer ${Constants.API_KEY}")
    @GET
    @Streaming
    suspend fun downloadImage(@Url fileUrl: String): ResponseBody
}
