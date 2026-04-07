package com.nova.music.domain.repository

import com.nova.music.domain.model.Song

interface MusicRepository {
    suspend fun searchSongs(query: String): Result<List<Song>>
    suspend fun getSongDetails(videoId: String): Result<Song>
    suspend fun getLyrics(videoId: String): Result<String?>
    suspend fun getRecommendations(videoId: String): Result<List<Song>>
}
