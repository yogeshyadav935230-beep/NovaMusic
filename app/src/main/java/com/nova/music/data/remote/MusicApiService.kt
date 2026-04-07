package com.nova.music.data.remote

import com.nova.music.data.remote.dto.*
import retrofit2.http.*

interface MusicApiService {
    @POST("player")
    suspend fun getPlayerResponse(
        @Body body: Map<String, Any> = emptyMap(),
        @Query("videoId") videoId: String
    ): PlayerResponseDto

    @POST("browse")
    suspend fun getNextResponse(
        @Body body: Map<String, Any> = emptyMap(),
        @Query("videoId") videoId: String
    ): NextResponseDto

    @POST("browse")
    suspend fun getLyrics(
        @Body body: Map<String, Any> = emptyMap(),
        @Query("browseId") browseId: String
    ): LyricsResponseDto
}
